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
<title>用户登录</title>
</head>
<body background="${pageContext.request.contextPath }/images/bk9.png" style=" background-repeat:no-repeat ;
background-size:100% 100%;"
	style="background-repeat: no-repeat; background-size: 100% 100%; opacity: 0.9">

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
			<li><a href="${pageContext.request.contextPath }/index.jsp">首页</a></li>
			<li><a href="${pageContext.request.contextPath}/jsp/goods.jsp">商品</a></li>
			<li><a href="${pageContext.request.contextPath}/jsp/cart.jsp">购物车</a></li>
			<li><a href="${pageContext.request.contextPath}/jsp/alreadybuy.jsp">已购买</a></li>
		</ul>
	</div>

	<div id="regist-main">
		<form action="/shopping055/LoginServlet" methob="post">
			<h1>用户登录</h1>
			<p>
				<input type="text" name="username" placeholder="用户名" />
			</p>
			<p>
				<input type="password" name="password" placeholder="密码" /> <span>${essormsg}${DBMes}</span>
			</p>
			<p class="button">
				<a href="${pageContext.request.contextPath }/jsp/register.jsp"><input
					value="没有账号 ?点击注册" /></a> <input type="submit" value="登录" />
			</p>
		</form>
	</div>
</body>
</html>