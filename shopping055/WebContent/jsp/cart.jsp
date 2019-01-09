<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="dao.ShoppingcartDAO"%>
<%@ page import="bean.Cart"%>
<%@ page import="dao.GoodsDAO"%>
<%@ page import="bean.Goods"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="web.DetailServlet"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/layout.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/cart.css" />
<title>购物车</title>
</head>
<body background="${pageContext.request.contextPath }/images/bk2.png" style=" background-repeat:no-repeat ;
background-size:80% 80%;background-position:300px 100px;">

	<div id="head">
		<img src="${pageContext.request.contextPath }/images/logo.png"
			id="logo" />
		<div id="a">
			<%
				if (session.getAttribute("user") == null) {
			%>
			<a href="${pageContext.request.contextPath }/jsp/login.jsp">请登录</a>
			or <a href="${pageContext.request.contextPath }/jsp/register.jsp">注册</a>
			<%
				} else {
			%>
			<a href="#">用户名: ${user}</a>
			<%
				}
			%>
		</div>
	</div>
	<div id="nav">
		<ul>
			<li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
			<li><a href="${pageContext.request.contextPath}/jsp/goods.jsp">商品</a></li>
			<li><a href="${pageContext.request.contextPath}/jsp/cart.jsp">购物车</a></li>
			<li><a href="${pageContext.request.contextPath}/jsp/alreadybuy.jsp">已购买</a></li>
		</ul>
	</div>
	  
	 	<div id="good">
			<p>用户名: ${user}</p>
			<p>订单列表:</p>
		<% 	 
	    if (session.getAttribute("user") == null) {
 		 %>
 			 <jsp:forward page="login.jsp" />
  		<%
	    return;
	    }
  		%>
		<%
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			ShoppingcartDAO shoppingdao = new ShoppingcartDAO();
			ArrayList<Cart> list = shoppingdao.getAllGoods(session.getAttribute("user"));
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						Cart item = list.get(i);
						GoodsDAO goodsDao = new GoodsDAO();
						Goods list1 = goodsDao.getGoodId(item.getId());
						%>

			<div id="one" style="padding:5px;">
				<div id="left">
					<img src="${pageContext.request.contextPath }/images/<%=list1.getPhoto() %>"/>
				</div>
				<div id="right">
					购买物品:<p><%=item.getGoodname()%></p><br/>
					数量:<p><%=item.getNum() %></p><br/>
					单价:<p><%=item.getPrice()%></p><br/>
					<div class="goumai" name="goumai"><a href="/shopping055/DeleteCartServlet?id=<%=item.getId() %>&flag=a">点击购买</a></div>
					<div class="shanchu" name="shanchu"><a href="/shopping055/DeleteCartServlet?id=<%=item.getId() %>">点击删除</a></div>
				</div>
			</div>
			<%
				}
				}
			%>
		</div>
	
</body>
</html>