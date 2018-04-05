<%--
  Created by IntelliJ IDEA.
  User: listener
  Date: 2017/12/6
  Time: 下午3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/resources/plugin/layui/css/layui.css" media="all">
</head>

<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend>已存在账户？<a href="/main.do"><span style="color: red">登录</span></a></legend>
</fieldset>

<form class="layui-form" action="" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input type="text" id="username" name="username" lay-verify="required" placeholder="请输入" autocomplete="off"
                   class="layui-input">
        </div>
        <!-- 对号 -->
        <div class="layui-inline">
            <i class="layui-icon" id="ri" style="color: green;font-weight: bolder;" hidden></i>
        </div>
        <!-- 错号 -->
        <div class="layui-inline">
            <i class="layui-icon" id="wr" style="color: red; font-weight: bolder;" hidden>ဆ</i>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" id="pwd" name="password" lay-verify="required" placeholder="请输入" autocomplete="off"
                   class="layui-input">
        </div>
        <!-- 对号 -->
        <div class="layui-inline">
            <i class="layui-icon" id="pri" style="color: green;font-weight: bolder;" hidden></i>
        </div>
        <!-- 错号 -->
        <div class="layui-inline">
            <i class="layui-icon" id="pwr" style="color: red; font-weight: bolder;" hidden>ဆ</i>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">验证密码</label>
        <div class="layui-input-inline">
            <input type="password" id="rpwd" name="checkPassword" lay-verify="required|check" placeholder="请输入" autocomplete="off"
                   class="layui-input">
        </div>
        <!-- 对号 -->
        <div class="layui-inline">
            <i class="layui-icon" id="rpri" style="color: green;font-weight: bolder;" hidden></i>
        </div>
        <!-- 错号 -->
        <div class="layui-inline">
            <i class="layui-icon" id="rpwr" style="color: red; font-weight: bolder;" hidden>ဆ</i>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="sub">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>


</body>

<script src="${ctx}/resources/plugin/layui/layui.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script src="${ctx}/resources/js/register.js"></script>

</html>
