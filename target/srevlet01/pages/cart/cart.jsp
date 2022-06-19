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
    <span class="wel_word">购物车</span>
    <%@ include file="/pages/common/login_com.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>编号</td>
            <td>书名</td>
            <td>价格</td>
            <td>数量</td>
            <td colspan="2">操作</td>
        </tr>
        <c:if test="${empty requestScope.record}">
            <tr>
                <td colspan="5">当前购物车为空！</td>
            </tr>
        </c:if>
        <c:if test="${not empty requestScope.record}">
            <c:forEach items="${requestScope.record}" var="cart">
                <tr>
                    <td>${cart.id}</td>
                    <td>${cart.bookName}</td>
                    <td>${cart.price}</td>
                    <td>${cart.bookQuanities}</td>
                    <td><a href="/bookstore/deleteCart?id=${cart.id}">删除</a></td>
                    <td><a href="/bookstore/updateCart?id=${cart.id}">添加</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

    <c:if test="${not empty requestScope.record}">
    <div class="cart_info">
        <span class="cart_span">购物车中共有<span class="b_count">${requestScope.record.size()}</span>件商品</span>
        <span class="cart_span">总金额<span class="b_price">${requestScope.allPrice}</span>元</span>
        <span class="cart_span"><a href="/bookstore/clearCart">清空购物车</a></span>
        <span class="cart_span"><a href="/bookstore/payment">去结账</a></span>
    </div>
    </c:if>

</div>

<%@include file="/pages/common/foot_com.jsp" %>
</body>
</html>