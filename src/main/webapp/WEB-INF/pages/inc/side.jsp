<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree" lay-filter="system">
            <shiro:hasAnyRoles name="admin">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:iframeByUrl('/food/userInfo.do');">用户信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">商户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:iframeByUrl('/food/restuarantInfo.do');">商户信息</a></dd>
                    </dl>
                </li>
            </shiro:hasAnyRoles>
            <shiro:hasRole name="business">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">菜品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:iframeByUrl('/food/foodInfo.do');">菜品信息</a></dd>
                    </dl>
                </li>
            </shiro:hasRole>
            <li class="layui-nav-item layui-nav-itemed">
                <a class="" href="javascript:;">订单管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:iframeByUrl('/food/orderInfo.do');">订单信息</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>
