<%--
  Created by IntelliJ IDEA.
  User: listener
  Date: 2018/4/6
  Time: 上午10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>新增商家</title>
    <link rel="stylesheet" href="/resources/plugin/layui/css/layui.css" media="all">
    <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
</head>
<body>

<form class="layui-form" action="" method="post" enctype="multipart/form-data">
    <shiro:hasRole name="admin">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input type="text" id="username" name="username" lay-verify="required" placeholder="请输入"
                       autocomplete="off"
                       class="layui-input">
            </div>
            <!-- 对号 -->
                <%--<div class="layui-inline">--%>
                <%--<i class="layui-icon" id="ri" style="color: green;font-weight: bolder;" hidden></i>--%>
                <%--</div>--%>
                <%--<!-- 错号 -->--%>
                <%--<div class="layui-inline">--%>
                <%--<i class="layui-icon" id="wr" style="color: red; font-weight: bolder;" hidden>ဆ</i>--%>
                <%--</div>--%>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" id="pwd" name="password" lay-verify="required" placeholder="请输入"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">验证密码</label>
            <div class="layui-input-inline">
                <input type="password" id="ckpwd" name="checkPassword" lay-verify="required|check" placeholder="请输入"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
    </shiro:hasRole>
    <shiro:hasRole name="business">
        <div class="layui-form-item">
            <label class="layui-form-label">商户名称</label>
            <div class="layui-input-inline">
                <input type="text" id="restaurantName" name="restaurantName" lay-verify="required" placeholder="请输入"
                       autocomplete="off"
                       class="layui-input databack">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商户简介</label>
            <div class="layui-input-inline">
            <textarea id="restaurantInfo" name="restaurantInfo" lay-verify="required"
                      autocomplete="off" class="layui-input databack" style="height: 218px;width: 501px;"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商户图片</label>
            <div class="layui-input-inline">
                <input type="text" id="bossPicturePath" name="bossPicturePath" lay-verify="required" placeholder="图片地址"
                       autocomplete="off" readonly="readonly"
                       class="layui-input databack">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"></label>
            <div class="layui-input-inline">
                <div class="layui-upload">
                    <button type="button" class="layui-btn" id="test1">上传图片</button>
                    <div class="layui-upload-list">
                        <img class="layui-upload-img" id="demo1">
                        <p id="demoText"></p>
                    </div>
                </div>
            </div>
        </div>
    </shiro:hasRole>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <shiro:hasRole name="admin">
                <button class="layui-btn" lay-submit="" lay-filter="sub">立即提交</button>
            </shiro:hasRole>
            <shiro:hasRole name="business">
                <button class="layui-btn" lay-submit="" lay-filter="update">立即提交</button>
            </shiro:hasRole>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

</body>
<script src="${ctx}/resources/plugin/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use('upload', function () {
        var $ = layui.jquery
            , upload = layui.upload;

//普通图片上传
        var uploadInst = upload.render({
            elem: '#test1'
            , url: '/file/imageUpload.do'
            , before: function (obj) {
//预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                if (res.code == 0) {
                    $('#bossPicturePath').val(res.data.url);
                }
//如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                }
//上传成功
            }
            , error: function () {
//演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });
    });
</script>

<script>
    layui.use(['layer', 'form', 'table'], function () {
        var form = layui.form,
            $ = layui.$;

        $.ajax({
            url: '/food/restuarants.do?type=databack',
            type: 'get',//默认以get提交，以get提交如果是中文后台会出现乱码
            dataType: 'json',
            success: function (obj) {
                debugger;
                if (obj.flag) {
                    //获取传参
                    var data = obj.data[0];
                    var inputArray = $(".databack");// 取到所有的input text
                    debugger;
                    inputArray.each(function () {
                        var input = $(this);// 循环中的每一个input元素
                        var name = input.attr("name");
                        if (data[name] == 0) {
                            input.val(data[name]);
                        } else if (data[name] != "" && data[name] != null) {
                            input.val(data[name]);
                        }
                    });
                    form.render();//重新渲染
                } else {
                }
            }
        });

        /**
         * 自定义校验
         */
        form.verify({
            check: function (value, item) { //value：表单的值、item：表单的DOM对象
                var password = $('#pwd').val();
                if (password !== value) {
                    return "两次密码输入不一致"
                }
            }
        });

        /**
         * 监听提交
         */
        form.on('submit(sub)', function (data) {
            $.ajax({
                url: '/food/addRestuarant.do',
                type: 'PUT',
                data: JSON.stringify(data.field),
                dataType: 'json',
                contentType: 'application/json;charset=UTF-8',
                success: function (res) {
                    var index = parent.layer.getFrameIndex("addID")
                    if (res.flag == true) {
                        layer.msg(res.msg);
                        parent.layer.close(index);
                        parent.location.reload()
                    } else {
                        layer.msg(res.msg);
                    }
                }
            })
            //防止页面跳转
            return false;
        });


        /**
         * 监听提交
         */
        form.on('submit(update)', function (data) {
            $.ajax({
                url: '/food/updateRestuarant.do',
                type: 'PUT',
                data: JSON.stringify(data.field),
                dataType: 'json',
                contentType: 'application/json;charset=UTF-8',
                success: function (res) {
                    if (res.flag == true) {
                        layer.msg(res.msg);

                    } else {
                        layer.msg(res.msg);
                    }
                }
            })
            //防止页面跳转
            return false;
        });

    });
</script>
</html>
