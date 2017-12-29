<%--
  Created by IntelliJ IDEA.
  User: listener
  Date: 2017/12/6
  Time: 下午3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/pages/inc/taglibs.jsp" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form action="" method="post">
    用户名：<input type="text" name="username" value="<shiro:principal/>"><br/>
    密 码：<input type="password" name="password"><br/>
    自动登录：<input type="checkbox" name="rememberMe" value="true"><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>
