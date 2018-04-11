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
    <title>菜品发布</title>
    <link rel="stylesheet" href="/resources/plugin/layui/css/layui.css" media="all">
    <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
</head>
<body>

<form class="layui-form" action="" method="post" enctype="multipart/form-data">
        <div class="layui-form-item">
            <label class="layui-form-label">菜品名称</label>
            <div class="layui-input-inline">
                <input type="text" id="foodName" name="foodName" lay-verify="required" placeholder="请输入"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
    <div class="layui-form-item">
        <label class="layui-form-label">菜品价格</label>
        <div class="layui-input-inline">
            <input type="number" id="price" name="price" lay-verify="required" placeholder="请输入"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">菜品描述</label>
            <div class="layui-input-inline">
            <textarea id="foodInfo" name="foodInfo" lay-verify="required"
                      autocomplete="off" class="layui-input" style="height: 118px;width: 300px;"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">菜品图片</label>
            <div class="layui-input-inline">
                <input type="text" id="picturePath" name="picturePath" lay-verify="required" placeholder="图片地址"
                       autocomplete="off" readonly="readonly"
                       class="layui-input">
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


    <div class="layui-form-item">
        <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="sub">立即提交</button>
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
                    $('#picturePath').val(res.data.url);
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

        /**
         * 监听提交
         */
        form.on('submit(sub)', function (data) {
            $.ajax({
                url: '/food/addFood.do',
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

    });
</script>
</html>