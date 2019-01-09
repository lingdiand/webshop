<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="dao.GoodsDAO"%>
<%@ page import="bean.Goods"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="web.DetailServlet"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/layout.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/detail.css" />
<title>商品详情</title>
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
	 		GoodsDAO goodsDao = new GoodsDAO();
	 	//	int id1=(int)session.getAttribute("id"); 
	 		Goods item = goodsDao.getGoodId(session.getAttribute("id"));
       %>
	<div id="good">
		<div id="left">
			<img src="${pageContext.request.contextPath }/images/<%=item.getPhoto() %>" />
		</div>
		<div id="right">
			<h1><%=item.getName() %></h1>
			<p><%=item.getText() %></p>
			<div id="price">
				价格:&nbsp;&nbsp;&nbsp;
				<p><%=item.getPrice() %></p>
			</div>
			<form action="/shopping055/AddCartServlet" methob="post">
				数量:<input type="text" value="1" id="num" name="num"/><br /> 
				<input type="submit" value="点击添加购物车" id="submit" />
			</form>
		</div>
	</div>

</body>
</html>