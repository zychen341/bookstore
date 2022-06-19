<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <base href="http://localhost:8080/bookstore/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css" >
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }
    </style>

    <script>
        alert("两次输入的密码不一致，请重新输入！")
    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="../../static/img/logo.jpg">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>用户注册</h1>
                    <a href="/bookstore/pages/user/login.jsp">立即登录</a>
                </div>
                <div class="form">
                    <form action="/bookstore/accountAdd">
                        <br/>
                        <br/>
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="accountName" id="accountName"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/foot_com.jsp" %>
</body>
</html>