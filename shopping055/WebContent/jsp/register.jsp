<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath }/css/layout.css" />
	<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath }/css/register.css" />
<title>用户注册</title>
</head>
<body background="${pageContext.request.contextPath }/images/bk5.png"
	style="background-repeat: no-repeat; background-size: 100% 100%;">
	<div id="head">
		<img src="${pageContext.request.contextPath }/images/logo.png" id="logo"/>
		<div id="a">
			<a href="${pageContext.request.contextPath }/jsp/login.jsp">请登录</a>
			or
			<a href="${pageContext.request.contextPath }/jsp/register.jsp">注册</a>
			<a href="#">${user}</a>
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
		<form action="/shopping055/ControllerServlet" methob="post">
		<h1>新用户注册</h1>
	<p >
		<input type="text" name="name" value="${formbean.name}" placeholder="设置用户名"/>
		<span>${formBean.errors.name}${DBMes}</span>
		
	</p>
	<p>
		<input type="password" name="password" placeholder="设置你的密码"/>
		<span>${formBean.errors.password}</span>
	</p>
	<p>
		<input type="password" name="password2"placeholder="请再次输入你的密码"/>
		<span>${formBean.errors.password2}</span>
	</p>
	<p>
		<input type="text" name="number" value="${formbean.number}"placeholder="输入电话号码"/>
		<span>${formBean.errors.number}</span>
	</p>
	
	<p class="button">
		<input type="reset" value="重置"/>
		<input type="submit" value="注册"/>
	</p>
		</form>	
	</div>	
</body>
</html>