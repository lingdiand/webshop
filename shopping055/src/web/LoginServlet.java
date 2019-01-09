package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		boolean b = UsersDAO.findUser(username, password);
		
		if (!b) {
			request.setAttribute("essormsg", "用户名或密码错误");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			return;
		}
		HttpSession session = request.getSession();
		request.getSession().setAttribute("user", username);
		request.getSession().setAttribute("userBean", username);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}
}
