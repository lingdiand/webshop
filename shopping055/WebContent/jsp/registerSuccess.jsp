<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/layout.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/register.css" />
<title>注册成功</title>
</head>
<style>
.denglu{
	background:red;
	text-align:center;
	font-size:22px;
	padding:10px;
}
.denglu a:hover{
	color:white;
}
</style>
<body>
	<div id="head">
		<img src="${pageContext.request.contextPath }/images/logo.png"
			id="logo" />
		<div id="a">
			<a href="${pageContext.request.contextPath }/jsp/login.jsp">请登录</a>
			or
			<a href="${pageContext.request.contextPath }/jsp/register.jsp">注册</a>
		</div>
	</div>
	<div id="nav">
		<ul>
			<li><a href="${pageContext.request.contextPath }/index.jsp">首页</a></li>
			<li><a href="${pageContext.request.contextPath}/jsp/goods.jsp">商品</a></li>
			<li><a href="${pageContext.request.contextPath}/jsp/cart.jsp">购物车</a></li>
			<li><a href="${pageContext.request.contextPath}/jsp/alreadybuy.jsp">已购买</a></li>
		</ul>
	</div>
	    <%
		    if (session.getAttribute("user") == null) {
	    %>
	    <jsp:forward page="register.jsp" />
	    <%
		    return;
		    }
	    %>

	<div id="regist-main">
		<form action="/shopping055/ControllerServlet" methob="post">
			<h1>注册成功!</h1>
			<div class="denglu"><a href="${pageContext.request.contextPath }/jsp/login.jsp">点击登录</a></div>
		</form>
	</div>
</body>
</html>