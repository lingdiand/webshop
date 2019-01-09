package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UsersDAO;
import util.RegisterFromBean;

public class ControllerServlet extends HttpServlet {
	public ControllerServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String number = request.getParameter("number");

		RegisterFromBean formBean = new RegisterFromBean();
		formBean.setName(name);
		formBean.setPassword(password);
		formBean.setPassword2(password2);
		formBean.setNumber(number);

		if (!formBean.validate()) {
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
			return;
		}

		User userBean = new User();
		userBean.setName(name);
		userBean.setPassword(password);
		userBean.setNumber(number);
		boolean b = UsersDAO.insert(userBean);
		if (!b) {
			request.setAttribute("DBMes", "你注册的用户已经存在");
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
			return;
		}

		request.getSession().setAttribute("userBean", userBean);
		response.sendRedirect(request.getContextPath()+"/jsp/registerSuccess.jsp");
	}

}
