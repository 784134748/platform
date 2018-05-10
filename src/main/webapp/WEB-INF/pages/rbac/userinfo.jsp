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
    <title>完善注册信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/resources/plugin/layui/css/layui.css" media="all">
</head>

<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px;">
    <legend>完善/修改个人信息</legend>
</fieldset>

<form class="layui-form" action="" method="post">
    <div class="layui-form-item layui-hide">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input type="text" id="username" name="username" lay-verify="required" placeholder="请输入" autocomplete="off"
                   class="layui-input" value="<shiro:principal/>">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">联系方式</label>
        <div class="layui-input-inline">
            <input type="text" id="telephone" name="telephone" lay-verify="required" placeholder="请输入" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">宿舍楼栋</label>
        <div class="layui-input-inline">
            <input type="text" id="address" name="address" lay-verify="required" placeholder="请输入" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">学生证件</label>
        <div class="layui-input-inline">
            <input type="text" id="number" name="number" lay-verify="required" placeholder="请输入" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sexType" value="男" title="男">
                <input type="radio" name="sexType" value="女" title="女" checked>
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
<script src="${ctx}/resources/js/user.js"></script>

</html>
