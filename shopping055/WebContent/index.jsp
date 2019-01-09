<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/layout.css" />
<title>汉韵二胡</title>
</head>
<body>
	<div id="head">
		<img src="images/logo.png" id="logo" />
		<div id="a">
		 <%
		    if (session.getAttribute("user") == null) {
	    %>
	   <a href="jsp/login.jsp">请登录</a> or <a href="jsp/register.jsp">注册</a>
	    <%
		    }else{
	    %>
			
			<a href="#">用户名: ${user}</a>
		  <%
		    }
	    %>
		</div>
	</div>
	<div id="nav">
		<ul>
			<li><a href="index.jsp">首页</a></li>
			<li><a href="jsp/goods.jsp">商品</a></li>
			<li><a href="jsp/cart.jsp">购物车</a></li>
			<li><a href="jsp/alreadybuy.jsp">已购买</a></li>
		</ul>
	</div>
	<img src="images/bizhi6.png" width="100%"/>
</body>
</html>