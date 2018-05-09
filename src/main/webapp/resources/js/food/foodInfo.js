layui.use(['form', 'layer', 'table', 'carousel', 'upload', 'element'], function () {
    var layer = layui.layer, //弹层
        form = layui.form,
        table = layui.table,
        $ = layui.$; //表格


    var index = layer.load(1);//开启进度条

    table.render({
        elem: '#table',//table id
        url: '/food/foods.do',
        method: 'get', //方式
        page: true,//是否开启分页
        type: "json",
        limits: [10, 20, 30, 60, 90, 100],
        limit: 10, //默认采用20
        cellMinWidth: 120,
        even: true, //开启隔行背景
        id: 'searchID',
        even: true, //开启隔行背景
        where:{type:1},
        done: function (res) {
            //加载后回调
            layer.close(index);//关闭
        },
        cols: [[ //标题栏
            {
                field: 'foodName',
                title: '菜品名称',
                align: 'center',
                width: '20%'
            }, {
                field: 'price',
                title: '菜品价格',
                align: 'center',
                width: '20%'
            }, {
                field: 'foodInfo',
                title: '菜品简介',
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


    //查询按钮
    $('#queryByCondition').on('click', function () {
        debugger;
        event.preventDefault();
        index = layer.load(1);//开启进度条
        var searchform = pubUtil.serializeObject($("#searchform"));//查询页面表单ID
        table.reload('searchID', {
            where: searchform
        });
    });


    /**
     * 新增商户
     */
    var active = {
        btnAdd: function () { //新增操作
            openAdd();
        }
    };

    $('.layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    function openAdd() {
        event.preventDefault();
        var index = layer.open({
            type: 2,
            title: '新增菜品',
            shadeClose: true,//点击遮罩关闭
            anim: public_anim,
            btnAlign: 'c',
            shade: false,//是否有遮罩，可以设置成false
            area: ['480px', '600px'],
            fixed: true,
            boolean: true,
            id: "addID",
            content: ['/food/addFood.do', 'yes'], //iframe的url，no代表不显示滚动条
            success: function (layero, lockIndex) {
            }
        })
    }


    /**
     * 监听工具条
     */
    table.on('tool(table)', function (obj) { //注：tool是工具条事件名，table是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data;
        var layEvent = obj.event; //获得 lay-event 对应的值
        if (layEvent === 'locked') {
            accountLocked(data);
        } else if (layEvent === 'unlocked') {
            accountUnlocked(data);
        } else if (layEvent === 'edit') {
            editFood(data);
        }
    });


    /**
     * 菜品上架
     * @param data
     */
    function accountLocked(data) {
        event.preventDefault();
        $.ajax({
            url: '/food/fixFoodState.do',
            type: 'POST',
            data: {foodState: 0, foodId: data.id},
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
     * 菜品下架
     */
    function accountUnlocked(data) {
        event.preventDefault();
        $.ajax({
            url: '/food/fixFoodState.do',
            type: 'POST',
            data: {foodState: 1, foodId: data.id},
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
     * 菜品编辑
     */
    function editFood(data) {
        event.preventDefault();
        var index = layer.open({
            type: 2,
            title: '编辑菜品',
            shadeClose: true,//点击遮罩关闭
            anim: public_anim,
            btnAlign: 'c',
            shade: false,//是否有遮罩，可以设置成false
            area: ['480px', '600px'],
            fixed: true,
            boolean: true,
            id: "addID",
            content: ['/food/addFood.do?obj=' + encodeURIComponent(JSON.stringify(data)), 'yes'], //iframe的url，no代表不显示滚动条
            success: function (layero, lockIndex) {
            }
        })
    };

});