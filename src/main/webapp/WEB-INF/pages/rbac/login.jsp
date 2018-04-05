<%--
  Created by IntelliJ IDEA.
  User: listener
  Date: 2017/12/6
  Time: 下午3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/inc/taglibs.jsp" %>
<html>
<head>
    <title>后台登录</title>
    <!-- Custom Theme files -->
    <link href="${ctx}/resources/css/login.css" rel="stylesheet"/>
    <!-- Custom Theme files -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="后台登录" />
</head>
<body>
<!--header start here-->
<div class="login-form">
    <div class="top-login">
        <span><img src="${ctx}/resources/images/group.png" alt=""/></span>
    </div>
    <h1>登录</h1>
    <div class="login-top">
        <form action="" method="post">
            <div class="login-ic">
                <i ></i>
                <input type="text" name="username" value="<shiro:principal/>">
                <div class="clear"> </div>
            </div>
            <div class="login-ic">
                <i class="icon"></i>
                <input type="password" name="password"><br/>
                <div class="clear"> </div>
            </div>

            <div class="log-bwn">
                <input type="submit" value="登录">
            </div>
        </form>
    </div>
    <p class="copy">©www.yalonglee.com <a href="#" target="_blank">首页</a></p>
</div>
</body>
</html>
