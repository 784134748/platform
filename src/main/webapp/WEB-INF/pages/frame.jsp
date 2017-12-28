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
    <%@ include file="/WEB-INF/pages/inc/meta.jsp" %>
    <title>后台管理系统</title>
    <%@ include file="/WEB-INF/pages/inc/style.jsp" %>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="inc/header.jsp"/>
    <jsp:include page="inc/side.jsp"/>
    <jsp:include page="inc/body.jsp"/>
    <jsp:include page="inc/footer.jsp"/>
</div>
<script src="/resources/plugin/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
