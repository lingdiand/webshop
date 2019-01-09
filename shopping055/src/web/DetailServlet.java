package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DetailServlet extends HttpServlet {
    public DetailServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out2 = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	    response.setHeader("content-type", "text/html;charset=UTF-8");
		String id=request.getParameter("id");
		HttpSession session = request.getSession();
		
		session.setAttribute("id", id);
	//out2.println(request.getSession().getAttribute("id") );
		response.sendRedirect(request.getContextPath()+"/jsp/details.jsp");
		
	}

}
