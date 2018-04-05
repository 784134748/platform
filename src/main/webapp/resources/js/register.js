layui.use(['layer', 'form', 'table'], function () {
    var form = layui.form,
        $ = layui.$;


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
        debugger;
        $.ajax({
            url: '/rbac/register.do',
            type: 'PUT',
            data: JSON.stringify(data.field),
            dataType: 'json',
            contentType:'application/json;charset=UTF-8',
            success: function (res) {
                debugger;
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