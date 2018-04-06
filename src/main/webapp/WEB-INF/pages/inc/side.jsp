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
                    <a class="" href="javascript:;">商家管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:iframeByUrl('/food/addBusiness.do');">商家入驻</a></dd>
                    </dl>
                </li>
            </shiro:hasAnyRoles>
            <shiro:hasAnyRoles name="admin,business">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">菜品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:iframeByUrl('/food/addFood.do');">菜品发布</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">订单管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:iframeByUrl('/food/orderInfo.do');">订单信息</a></dd>
                    </dl>
                </li>
            </shiro:hasAnyRoles>
        </ul>
    </div>
</div>
