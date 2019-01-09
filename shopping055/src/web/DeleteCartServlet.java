package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShoppingcartDAO;
import dao.alreadybuyDAO;

public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	//通过a标签传递的flag来判断是要购买还是删除
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	    response.setHeader("content-type", "text/html;charset=UTF-8");
		String id=request.getParameter("id");
		if(request.getParameter("flag") != null) {
			alreadybuyDAO.insert(id);
			ShoppingcartDAO.delGoodId(id);
			response.sendRedirect(request.getContextPath()+"/jsp/addSuccess2.jsp");
		}else if(request.getParameter("flag") == null){ 
			ShoppingcartDAO.delGoodId(id);
			response.sendRedirect(request.getContextPath()+"/jsp/delSuccess.jsp");
		}else {
			PrintWriter out=response.getWriter();
			out.println(request.getParameter("erros"));
		}
	}	

}
