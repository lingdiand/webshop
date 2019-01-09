<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.GoodsDAO"%>
<%@ page import="bean.Goods"%>
<%@ page import="java.util.ArrayList"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/layout.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/goods.css" />
<title>商品</title>
</head>
<body background="${pageContext.request.contextPath }/images/bk1.png"
	style="background-repeat: no-repeat; background-size: 100% 150%;">

	<div id="head">
		<img src="${pageContext.request.contextPath }/images/logo.png"
			id="logo" />
		<div id="a">
			<%
				if (session.getAttribute("user") == null) {
			%>
			<a href="${pageContext.request.contextPath}/jsp/login.jsp">请登录</a> or
			<a href="${pageContext.request.contextPath }/jsp/register.jsp">注册</a>
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
			<li><a
				href="${pageContext.request.contextPath}/jsp/alreadybuy.jsp">已购买</a></li>
		</ul>
	</div>

	<div id="good">
		<ul id="frist">
			<%
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				GoodsDAO goodsDao = new GoodsDAO();
				ArrayList<Goods> list = goodsDao.getAllGoods();
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						Goods item = list.get(i);
			%>
			<li id="one"><a
				href="/shopping055/DetailServlet?id=<%=item.getId()%>"> <img
					src="${pageContext.request.contextPath }/images/<%=item.getPhoto() %>" />
					<p><%=item.getName()%></p> 价格
					<p><%=item.getPrice()%></p></a></li>
			<%
				}
				}
			%>
		</ul>
	</div>

</body>
</html>