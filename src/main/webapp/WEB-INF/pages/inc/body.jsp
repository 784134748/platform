<%--
  Created by IntelliJ IDEA.
  User: listener
  Date: 2017/12/13
  Time: 下午8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="layui-body">
    <!-- 内容主体区域 -->
    <shiro:hasAnyRoles name="admin">
        <iframe src="/food/userInfo.do" frameborder="0" style="width: 100%;height: 100%" name="iframe" id="iframe"
                scrolling="auto"></iframe>
    </shiro:hasAnyRoles>
    <shiro:hasRole name="business">
        <iframe src="/food/foodInfo.do" frameborder="0" style="width: 100%;height: 100%" name="iframe" id="iframe"
                scrolling="auto"></iframe>
    </shiro:hasRole>

</div>
