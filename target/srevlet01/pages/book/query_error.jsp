<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>搜索跳转页</title>
    <base href="http://localhost:8080/bookstore/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css" >
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: #ff0000;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.jpg">
    <span class="wel_word"></span>
</div>

<div id="main">

    <h1>对不起!本书城暂未收录该书。 <a href="/bookstore/showAllBooks">返回</a></h1>

</div>

<%@include file="/pages/common/foot_com.jsp" %>
</body>
</html>