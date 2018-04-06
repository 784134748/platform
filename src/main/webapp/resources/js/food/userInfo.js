layui.use(['form', 'layer', 'table', 'carousel', 'upload', 'element'], function () {
    var layer = layui.layer, //弹层
        form = layui.form,
        table = layui.table; //表格


    var index = layer.load(1);//开启进度条

    table.render({
        elem: '#table',//table id
        url: '/rbac/user',
        method: 'get', //方式
        type: "json",
        even: true, //开启隔行背景
        done: function (res) {
            //加载后回调
            layer.close(index);//关闭
        },
        cols: [[ //标题栏
            {
                field: 'username',
                title: '用户名',
                align: 'center',
                width: '20%'
            }, {
                field: 'locked',
                title: '状态',
                align: 'center',
                width: '20%'
            }, {
                fixed: 'right',
                title: '操作',
                align: 'center',
                toolbar: '#toobar',
                width: '20%'
            }]]
    });

    //
    // //查询按钮
    // $('#queryByCondition').on('click', function () {
    //     event.preventDefault();
    //     index = layer.load(1);//开启进度条
    //     var searchform = pubUtil.serializeObject($("#searchform"));//查询页面表单ID
    //     table.reload('searchID', {
    //         where: searchform
    //     });
    // });

    // /**
    //  * 学年下拉框
    //  */
    // $.ajax({
    //     url: "year.do",
    //     type: 'GET',
    //     dataType: 'json',
    //     async: true,
    //     success: function (data) {
    //         $("#year").html("");
    //         $("#year").append('<option selected="" value="">选择学年</option>');
    //         for (var i = 0; i < data.length; i++) {
    //             $("#year").append('<option value=' + data[i][0] + '>' + data[i][1] + '</option>');
    //         }
    //         form.render();
    //     }
    // });

    // /**
    //  * 监听工具条
    //  */
    // table.on('tool(table)', function (obj) { //注：tool是工具条事件名，table是table原始容器的属性 lay-filter="对应的值"
    //     var data = obj.data //获得当前行数据
    //         , layEvent = obj.event; //获得 lay-event 对应的值
    //     if (layEvent === 'detail') {
    //         openDetail(data);
    //     } else if (layEvent === 'update') {
    //         openUpdate(data);
    //     }
    // });

    // var active = {
    //     btnAdd: function () { //新增操作
    //         openAdd();
    //     }
    // };
    //
    // $('.layui-btn').on('click', function () {
    //     var type = $(this).data('type');
    //     active[type] ? active[type].call(this) : '';
    // });

    // /**
    //  * 新增按钮
    //  */
    // function openAdd() {
    //     event.preventDefault();
    //     //校验当前学年的数据是否已存在
    //     $.ajax({
    //         url: 'get.do',
    //         type: 'POST',//默认以get提交，以get提交如果是中文后台会出现乱码
    //         dataType: 'json',
    //         async: true,
    //         success: function (obj) {
    //             if (obj.success) {
    //                 if (obj.obj == null) {
    //                     layer.open({
    //                         type: 2,
    //                         title: '新增',
    //                         shadeClose: true,//点击遮罩关闭
    //                         anim: public_anim,
    //                         btnAlign: 'c',
    //                         shade: false,//是否有遮罩，可以设置成false
    //                         area: ['100%', '100%'],
    //                         fixed: true,
    //                         boolean: true,
    //                         id: "addID",
    //                         content: ['form-view.do', 'yes'], //iframe的url，no代表不显示滚动条
    //                         success: function (layero, index) {
    //                         }
    //                     });
    //                 } else {
    //                     pubUtil.msg(obj.msg, layer, 2, function () {
    //                     }, 2 * 1000);
    //                 }
    //             } else {
    //                 pubUtil.msg(obj.msg, layer, 2, function () {
    //                 }, 2 * 1000);
    //             }
    //         }
    //     });
    //
    // }
    //
    // /**
    //  * 打开查看按钮
    //  * @param data
    //  */
    // function openDetail(data) {
    //     event.preventDefault();
    //     layer.open({
    //         type: 2,
    //         title: '详情',
    //         shadeClose: true,//点击遮罩关闭
    //         anim: public_anim,
    //         btnAlign: 'c',
    //         shade: false,//是否有遮罩，可以设置成false
    //         area: ['100%', '100%'],
    //         fixed: true,
    //         boolean: true,
    //         id: "detailID",
    //         content: ['detail-view.do?obj=' + encodeURIComponent(JSON.stringify(data)), 'yes'], //iframe的url，no代表不显示滚动条
    //         success: function (layero, lockIndex) {
    //         }
    //     });
    // }
    //
    // /**
    //  * 修改按钮
    //  */
    // function openUpdate(data) {
    //     event.preventDefault();
    //     layer.open({
    //         type: 2,
    //         title: '修改',
    //         shadeClose: true,//点击遮罩关闭
    //         anim: public_anim,
    //         btnAlign: 'c',
    //         shade: false,//是否有遮罩，可以设置成false
    //         area: ['100%', '100%'],
    //         fixed: true,
    //         boolean: true,
    //         id: "addID",
    //         content: ['form-view.do?obj=' + encodeURIComponent(JSON.stringify(data)), 'yes'], //iframe的url，no代表不显示滚动条
    //         success: function (layero, lockIndex) {
    //         }
    //     });
    // }

});