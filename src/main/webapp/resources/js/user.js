layui.use(['layer', 'form', 'table'], function () {
    var form = layui.form,
        $ = layui.$;


    /**
     * 自定义校验
     */
    form.verify({});

    /**
     * 监听提交
     */
    form.on('submit(sub)', function (data) {
        // var array = new Object();
        // var type = "perfect";
        // var user = data.field;
        // array.type = type;
        // array.user = user;
        // var json = JSON.stringify(array);
        $.ajax({
            url: '/rbac/register.do?type=perfect' + "&&sexType=" + data.field.sexType,
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