package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ShoppingcartDAO;
import dao.UsersDAO;

public class AddCartServlet extends HttpServlet {

    
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	    response.setHeader("content-type", "text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
			return ;
		}
	
		PrintWriter out2 = response.getWriter();
		String num=request.getParameter("num");
		String id=(String) session.getAttribute("id");
		String username=(String) session.getAttribute("user");
		ShoppingcartDAO.getGoodId(username,id,num);
		response.sendRedirect(request.getContextPath()+"/jsp/addSuccess.jsp");
	}

}
