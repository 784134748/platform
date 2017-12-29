<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree"  lay-filter="test">
            <li class="layui-nav-item layui-nav-itemed">
                <a class="" href="javascript:;">系统管理</a>
                <dl class="layui-nav-child">
                    <shiro:hasPermission name="admin:admin:all"><dd><a href="javascript:iframeByUrl('/sys/menu.do');">菜单管理</a></dd></shiro:hasPermission>
                    <shiro:hasPermission name="admin:admin:all"><dd><a href="javascript:iframeByUrl('/sys/user.do');">用户管理</a></dd></shiro:hasPermission>
                    <shiro:hasPermission name="admin:admin:all"><dd><a href="javascript:iframeByUrl('/sys/role.do');">角色管理</a></dd></shiro:hasPermission>
                    <shiro:hasPermission name="admin:admin:all"><dd><a href="javascript:iframeByUrl('/sys/permission.do');">权限管理</a></dd></shiro:hasPermission>
                    <shiro:hasPermission name="admin:admin:all"><dd><a href="javascript:iframeByUrl('/sys/dictionary.do');">字典管理</a></dd></shiro:hasPermission>
                </dl>
            </li>
        </ul>
    </div>
</div>
