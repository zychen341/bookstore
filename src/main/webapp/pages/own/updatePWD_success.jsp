<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>修改密码</title>
	<base href="http://localhost:8080/bookstore/">
	<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}
	</style>
	<script>
		alert("修改成功！")
	</script>
</head>
<body>
<div id="header">
	<img class="logo_img" alt="" src="../../static/img/logo.jpg" >
	<span class="wel_word">个人中心/修改密码</span>
	<div>
		<a href="/bookstore/index.jsp">退出登录</a>&nbsp;&nbsp;
		<a href="/bookstore/showAccount">返回</a>
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
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<center>
	<div class="form">
		<form action="/bookstore/updateAccount">
			<label>用户新密码：</label>
			<input class="itxt" type="text" placeholder="请输入新密码" autocomplete="off" tabindex="1" name="newpwd" />
			<br />
			<br />
			<label>确认新密码：</label>
			<input class="itxt" type="text" placeholder="确认新密码" autocomplete="off" tabindex="1" name="renewpwd" />
			<br />
			<br />
			<input type="submit" value="修改" id="sub_btn" />
		</form>
	</div>
	</center>
</div>
<%@include file="/pages/common/foot_com.jsp" %>
</body>
</html>