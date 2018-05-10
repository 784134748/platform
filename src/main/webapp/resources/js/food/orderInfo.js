layui.use(['form', 'layer', 'table', 'carousel', 'upload', 'element'], function () {
    var layer = layui.layer, //弹层
        form = layui.form,
        table = layui.table,
        $ = layui.$; //表格


    var index = layer.load(1);//开启进度条

    table.render({
        elem: '#table',//table id
        url: '/food/orders.do',
        method: 'get', //方式
        page: true,//是否开启分页
        type: "json",
        limits: [10, 20, 30, 60, 90, 100],
        limit: 10, //默认采用20
        cellMinWidth: 120,
        even: true, //开启隔行背景
        id: 'searchID',
        even: true, //开启隔行背景
        where:{type:"business"},
        done: function (res) {
            //加载后回调
            layer.close(index);//关闭
        },
        cols: [[ //标题栏
            {
                field: 'orderFood',
                title: '订购菜品',
                align: 'center',
                width: '10%'
            }, {
                field: 'orderUser',
                title: '订购人',
                align: 'center',
                width: '10%'
            }, {
                field: 'orderTime',
                title: '订购时间',
                align: 'center',
                width: '10%'
            },{
                field: 'orderPrice',
                title: '订购价格',
                align: 'center',
                width: '10%'
            },{
                field: 'telephone',
                title: '联系方式',
                align: 'center',
                width: '10%'
            },{
                field: 'orderAddress',
                title: '宿舍地址',
                align: 'center',
                width: '10%'
            },{
                field: 'studentNumber',
                title: '学生证件',
                align: 'center',
                width: '10%'
            }, {
                field: 'name',
                title: '订单状态',
                align: 'center',
                width: '10%',
                templet: '<div>{{d.orderState.name}}</div>'
            }, {
                fixed: 'right',
                title: '操作',
                align: 'center',
                toolbar: '#toobar',
                width: '20%'
            }]]
    });


    //查询按钮
    $('#queryByCondition').on('click', function () {
        event.preventDefault();
        index = layer.load(1);//开启进度条
        var searchform = pubUtil.serializeObject($("#searchform"));//查询页面表单ID
        table.reload('searchID', {
            where: searchform
        });
    });


    /**
     * 监听工具条
     */
    table.on('tool(table)', function (obj) { //注：tool是工具条事件名，table是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data;
        var layEvent = obj.event; //获得 lay-event 对应的值
        if (layEvent === 'onway') {
            accountLocked(data);
        } else if (layEvent === 'ok') {
            accountUnlocked(data);
        }
    });


    /**
     * 账号锁定
     * @param data
     */
    function accountLocked(data) {
        event.preventDefault();
        $.ajax({
            url: '/food/fixOrderState.do',
            type: 'POST',
            data: {orderState: 2, orderId: data.id},
            dataType: 'json',
            success: function (res) {
                if (res.flag == true) {
                    layer.msg(res.msg);
                    location.reload();
                } else {
                    layer.msg(res.msg);
                    location.reload();
                }
            }
        })
        //防止页面跳转
        return false;
    };

    /**
     * 账号解锁
     */
    function accountUnlocked(data) {
        event.preventDefault();
        $.ajax({
            url: '/food/fixOrderState.do',
            type: 'POST',
            data: {orderState: 3, orderId: data.id},
            dataType: 'json',
            success: function (res) {
                if (res.flag == true) {
                    layer.msg(res.msg);
                    location.reload();
                } else {
                    layer.msg(res.msg);
                    location.reload();
                }
            }
        })
        //防止页面跳转
        return false;
    };

});