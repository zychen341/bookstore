<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <base href="http://localhost:8080/bookstore/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css" >
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.jpg" >
    <span class="wel_word">网上书城</span>
    <div>
        <a href="/bookstore/showAccount">个人中心</a> |
        <a href="/bookstore/showPackage">我的背包</a> |
        <a href="/bookstore/showShoppingCart">购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/bookstore/index.jsp">退出登录</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="/bookstore/queryBook" method="get">
                书名：<input id="min" type="text" placeholder="请输入书籍名称" autocomplete="off" tabindex="1" name="bookName">
                <input type="submit" value="查询" />
            </form>
        </div>
        <div style="text-align: center">
            <br/>
            <br/>
        </div>
        <c:forEach items="${requestScope.test}" var="book">
        <div class="b_list">
            <div class="img_div">
                <img class="book_img" alt="" src="static/img/default.jpg" />
            </div>
            <div class="book_info">
                <div class="book_name">
                    <span class="sp1" >书名:</span>
                    <span class="sp2">${book.bookName}</span>
                </div>
                <div class="book_name">
                    <span class="sp1">作者:</span>
                    <span class="sp2">${book.author}</span>
                </div>
                <div class="book_name">
                    <span class="sp1">价格:</span>
                    <span class="sp2">￥${book.price}</span>
                </div>
                <div class="book_name">
                    <button onclick="window.location.href='/bookstore/addtoCart?id=${book.id}'">加入购物车</button>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</div>
<%@include file="/pages/common/foot_com.jsp" %>
</body>
</html>