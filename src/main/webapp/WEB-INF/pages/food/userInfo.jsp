<%--
  Created by IntelliJ IDEA.
  User: listener
  Date: 2018/4/6
  Time: 上午10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>用户信息</title>
    <link rel="stylesheet" href="${ctx}/resources/plugin/layui/css/layui.css" media="all">
</head>
<body>

<div class="container">
    <table class="layui-hide" id="table" lay-filter="table"></table>
</div>

</body>
<script src="${ctx}/resources/plugin/layui/layui.js" charset="utf-8"></script>
<script src="${ctx}/resources/js/food/userInfo.js" charset="utf-8"></script>
<script type="text/html" id="toobar">
    <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="update">修改</a>
</script>
</html>
