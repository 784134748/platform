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
    <title>购物车</title>
    <link rel="stylesheet" href="${ctx}/resources/plugin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${ctx}/resources/css/dataUp.css" media="all">
    <link rel="stylesheet" href="${ctx}/resources/css/common.css" media="all">
    <script src="${ctx}/resources/js/public.js" charset="utf-8"></script>
    <script src="${ctx}/resources/js/jquery-3.2.0.min.js" charset="utf-8"></script>
</head>
<body>

<div class="container">
    <form name="searchform" id="searchform" class="layui-form" method="post" action="">
        <div class="layui-form-item layui-row query-condition dotted">
            <div class="layui-col-md3 layui-col-sm3">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-block">
                    <input type="text" name="username" maxlength="10" placeholder="输入用户名" class="layui-input">
                </div>
            </div>
            <div class="layui-col-md4 layui-col-sm4 layui-col-md-offset5 clearfix">
                <button class="layui-btn layui-btn-normal fr mr10" id="queryByCondition">
                    <i class="iconfont icon-chaxun"></i> 查询
                </button>
            </div>
        </div>
    </form>
    <table class="layui-hide" id="table" lay-filter="table"></table>
</div>

</body>
<script src="${ctx}/resources/plugin/layui/layui.js" charset="utf-8"></script>
<script src="${ctx}/resources/js/food/shops.js" charset="utf-8"></script>
<script type="text/html" id="toobar">
    <a class="layui-btn layui-btn-xs" lay-event="sure">确认</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
</script>
</html>
