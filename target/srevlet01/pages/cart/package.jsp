<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <base href="http://localhost:8080/bookstore/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
    <span class="wel_word">背包</span>
    <div>
        <a href="/bookstore/showShoppingCart">购物车</a>
        <a href="/bookstore/index.jsp">退出登录</a>&nbsp;&nbsp;
        <a href="/bookstore/showAllBooks">返回</a>
    </div>
</div>

<div id="main">

    <table>
        <tr>
            <td>编号</td>
            <td>书名</td>
            <td>价格</td>
            <td>数量</td>
            <td>操作</td>
        </tr>
        <c:if test="${empty requestScope.packages}">
            <tr>
                <td colspan="5">当前背包为空！</td>
            </tr>
        </c:if>
        <c:if test="${not empty requestScope.packages}">
            <c:forEach items="${requestScope.packages}" var="pack">
                <tr>
                    <td>${pack.id}</td>
                    <td>${pack.bookName}</td>
                    <td>${pack.price}</td>
                    <td>${pack.bookQuanities}</td>
                    <td><a href="/bookstore/deletePackage?id=${pack.id}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

</div>

<%@include file="/pages/common/foot_com.jsp" %>
</body>
</html>