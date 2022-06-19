<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>个人中心</title>
	<base href="http://localhost:8080/bookstore/">
	<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}
	</style>
</head>
<body>
<div id="header">
	<img class="logo_img" alt="" src="../../static/img/logo.jpg" >
	<span class="wel_word">个人中心</span>
	<div>
		<a href="/bookstore/pages/own/updatePWD.jsp">修改密码</a> |
		<a href="/bookstore/pages/own/recharge.jsp">充值</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="/bookstore/index.jsp">退出登录</a>&nbsp;&nbsp;
		<a href="/bookstore/showAllBooks">返回</a>
	</div>
</div>

<div id="main">
	<table>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>账户名</td>
			<td>密码</td>
			<td>钱包</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>${requestScope.account.account}</td>
			<td>${requestScope.account.password}</td>
			<td>${requestScope.account.money}</td>
			<td>&nbsp;</td>
		</tr>
	</table>
</div>
<%@include file="/pages/common/foot_com.jsp" %>
</body>
</html>