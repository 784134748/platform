<%--
  Created by IntelliJ IDEA.
  User: listener
  Date: 2017/12/6
  Time: 下午3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/pages/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${ctx}/resources/plugin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${ctx}/resources/css/global.css" media="all">
    <link rel="stylesheet" href="${ctx}/resources/css/index.css" media="all">
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js" type="text/javascript"></script>
</head>
<body>

<div class="layui-container">
    <!--页头部分-->
    <div class="fly-header layui-bg-red">
        <div class="layui-container">
            <a class="fly-logo" href="/">
                <div class="layui-logo"><h1><b>校园餐厅</b></h1></div>
            </a>
            <ul class="layui-nav fly-nav layui-hide-xs">
                <li class="layui-nav-item layui-this">
                    <a href="/"><i class="iconfont icon-jiaoliu"></i>新闻公告</a>
                </li>
                <li class="layui-nav-item">
                    <a href="case/case.html"><i class="iconfont icon-iconmingxinganli"></i>质量监管</a>
                </li>
                <li class="layui-nav-item">
                    <a href="http://www.layui.com/" target="_blank"><i class="iconfont icon-ui"></i>联系方式</a>
                </li>
            </ul>

            <ul class="layui-nav fly-nav-user">
                <%--未登入的状态--%>
                <shiro:notAuthenticated>
                    <li class="layui-nav-item">
                        <a class="iconfont icon-touxiang layui-hide-xs" href="login.html"></a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="/rbac/login.do">登入</a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="/rbac/register.do" target="_blank">注册</a>
                    </li>
                </shiro:notAuthenticated>

                <!-- 登入后的状态 -->
                <shiro:user>
                    <li class="layui-nav-item">
                        <a class="fly-nav-avatar" href="javascript:;">
                            <cite class="layui-hide-xs"><shiro:principal/></cite>
                            <i class="layui-badge fly-badge-vip layui-hide-xs">用户！您好</i>
                            <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg">
                        </a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a href="/food/userOrder.do" target="_blank"><i class="layui-icon layui-icon-notice"
                                                                                style="top: 4px;"></i>我的订单</a>
                            </dd>
                            <dd>
                                <a href="/rbac/userinfo.do" target="_blank"><i class="layui-icon layui-icon-user"
                                                                               style="top: 4px;"></i>个人中心</a>
                            </dd>
                            <dd>
                                <a href="/food/userShop.do" target="_blank"><i class="layui-icon layui-icon-cart"
                                                                               style="top: 4px;"></i>购物车</a>
                            </dd>
                            <hr style="margin: 5px 0;">
                            <dd><a href="/rbac/logout.do" style="text-align: center;">退出</a></dd>
                        </dl>
                    </li>
                </shiro:user>
            </ul>
        </div>
    </div>

    <!--轮播图-->
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend>饮食小贴士</legend>
    </fieldset>
    <div class="layui-carousel" id="test1" lay-filter="test1">
        <div carousel-item="" style="border-radius: 15px">
            <div><img src="${ctx}/resources/images/001.jpg" style="width: 100%;height: 300px"></div>
        </div>
    </div>

    <!--套餐-->
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend>全部套餐</legend>
    </fieldset>
    <!--信息流，懒加载-->
    <ul class="flow-default" id="LAY_demo1"></ul>

    <div class="layui-container" style="border-radius: 5px;border:1px solid #FF5722;margin-top: 2px">
        <!--店铺-->
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
            <legend>店铺</legend>
        </fieldset>
    </div>
    <!--信息流，懒加载-->
    <ul class="flow-default" id="LAY_demo2"></ul>

    <div class="layui-footer">
        <div class="fly-panel">
            <div class="fly-panel-main">
                <a href="http://layim.layui.com/?from=fly" target="_blank" class="fly-zanzhu"
                   time-limit="2017.09.25-2099.01.01" style="background-color:#FF5722;">谁知盘中餐，粒粒皆辛苦。</a>
            </div>
        </div>
        <div class="fly-panel fly-link">
            <h3 class="fly-panel-title">友情链接</h3>
            <dl class="fly-panel-main">
                <dd>
                    <a href="mailto:xianxin@layui-inc.com?subject=%E7%94%B3%E8%AF%B7Fly%E7%A4%BE%E5%8C%BA%E5%8F%8B%E9%93%BE"
                       class="fly-link">申请友链</a>
                <dd>
            </dl>
            <dl class="fly-panel-main">
                <dd><a href="http://www.layui.com/" target="_blank">layui</a>
            </dl>
        </div>
    </div>
</div>
</div>


<script src="${ctx}/resources/plugin/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['carousel', 'form', 'element'], function () {
        var carousel = layui.carousel
            , form = layui.form;

        //常规轮播
        carousel.render({
            elem: '#test1'
            , arrow: 'always'
        });

        //改变下时间间隔、动画类型、高度
        carousel.render({
            elem: '#test1'
            , interval: 1800
            , anim: 'fade'
            , height: '120px'
        });

        //设定各种参数
        var ins3 = carousel.render({
            elem: '#test1'
        });
        //图片轮播
        carousel.render({
            elem: '#test1'
            , width: '100%'
            , height: '300px'
            , interval: 5000
        });

        //事件
        carousel.on('change(test4)', function (res) {
            console.log(res)
        });

        var $ = layui.$, active = {
            set: function (othis) {
                var THIS = 'layui-bg-normal'
                    , key = othis.data('key')
                    , options = {};

                othis.css('background-color', '#5FB878').siblings().removeAttr('style');
                options[key] = othis.data('value');
                ins3.reload(options);
            }
        };

        //监听开关
        form.on('switch(autoplay)', function () {
            ins3.reload({
                autoplay: this.checked
            });
        });

        $('.demoSet').on('keyup', function () {
            var value = this.value
                , options = {};
            if (!/^\d+$/.test(value)) return;

            options[this.name] = value;
            ins3.reload(options);
        });

        //其它示例
        $('.demoTest .layui-btn').on('click', function () {
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });
    });
</script>
<script>
    layui.use('flow', function () {
        var flow = layui.flow
            , $ = layui.$;

        flow.load({
            elem: '#LAY_demo1' //流加载容器
            , scrollElem: '#LAY_demo2' //滚动条所在元素，一般不用填，此处只是演示需要。
            , isAuto: false
            , isLazyimg: true
            , done: function (page, next) { //加载下一页
                //模拟插入
                // setTimeout(function () {
                // var lis = [];
                // for (var i = 0; i < 8; i++) {
                // lis.push('<li class="single-member effect-3">\n' +
                // '    <div class="member-image">\n' +
                // '        <img src="/resources/images/member_270x210.jpg" alt="Member">\n' +
                // '    </div>\n' +
                // '    <div class="member-info">\n' +
                // '        <h3>大盘鸡</h3>\n' +
                // '        <h5>￥11/份</h5>\n' +
                // '        <p>Lorem tempor incididunt ut labore et dolore magna aliqua.</p>\n' +
                // '        <div class="social-touch">\n' +
                // '            <a class="fb-touch" href="#"><h2>下单</h2></a>\n' +
                // '        </div>\n' +
                // '    </div>\n' +
                // '</li>')
                // }
                // next(lis.join(''), page < 8); //假设总页数为 8
                // }, 500);
                var lis = [];
                var count = 0;
                //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                $.get('/food/foods.do?limit=8&&page=' + page, function (res) {
                    //假设你的列表返回在data集合中
                    layui.each(res.data, function (index, item) {
                        lis.push('<li class="single-member effect-3">\n' +
                            '    <div class="member-image">\n' +
                            '        <img src="/file/imageView.do?picturePath=' + item.picturePath + '" alt="Member">\n' +
                            '    </div>\n' +
                            '    <div class="member-info">\n' +
                            '        <h3>' + item.foodName + '</h3>\n' +
                            '        <h5>￥' + item.price + '/份</h5>\n' +
                            '        <p>' + item.foodInfo + '</p>\n' +
                            '        <div class="social-touch">\n' +
                            '            <button class="fb-touch" onclick="addOrder(this.id)" id="' + item.id + '"><h2>加入购物车</h2></button>\n' +
                            '        </div>\n' +
                            '    </div>\n' +
                            '</li>')
                        count++;
                    });

                    if (count % 4 !== 0) {
                        for (var i = 0; i < 4 - count % 4; i++) {
                            lis.push('<li class="single-member effect-3">\n' +
                                '</li>')
                        }
                    }

                    //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                    //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                    next(lis.join(''), page < res.pages);
                });
            }
        });
        flow.load({
            elem: '#LAY_demo2' //流加载容器
            , scrollElem: '#LAY_demo2' //滚动条所在元素，一般不用填，此处只是演示需要。
            , isAuto: false
            , isLazyimg: true
            , done: function (page, next) { //加载下一页
                //模拟插入
                // setTimeout(function () {
                //     var lis = [];
                //     for (var i = 0; i < 8; i++) {
                //         lis.push('<li class="single-member effect-1">\n' +
                //             // '    <div class="member-image">\n' +
                //             // '        <img src="/resources/images/member_140x145.jpg" alt="Member">\n' +
                //             // '    </div>\n' +
                //             // '    <div class="member-info">\n' +
                //             // '        <h3>Sophia</h3>\n' +
                //             // '        <h5>ShowGilr</h5>\n' +
                //             // '        <p>Lorem ipsum dolor sit amet, consectetur adipiscin</p>\n' +
                //             // '        <div class="social-touch">\n' +
                //             // '            <a class="fb-touch" href="#"><h2>进店看看</h2></a>\n' +
                //             // '        </div>\n' +
                //             // '    </div>\n' +
                //             '</li>')
                //     }
                //     next(lis.join(''), page < 8); //假设总页数为 8
                // }, 500);
                var lis = [];
                var count = 0;
                //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                $.get('/food/restuarants.do?type=index&&limit=8&&page=' + page, function (res) {
                    //假设你的列表返回在data集合中
                    layui.each(res.data, function (index, item) {
                        lis.push('<li class="single-member effect-1">\n' +
                            '    <div class="member-image">\n' +
                            '        <img src="/file/imageView.do?picturePath=' + item.bossPicturePath + '" alt="Member">\n' +
                            '    </div>\n' +
                            '    <div class="member-info">\n' +
                            '        <h3>' + item.restaurantName + '</h3>\n' +
                            '        <h5>' + item.boss + '</h5>\n' +
                            '        <p>' + item.restaurantInfo + '</p>\n' +
                            '        <div class="social-touch">\n' +
                            '            <a class="fb-touch" href="/food/restuarant.do?restaurantId=' + encodeURIComponent(JSON.stringify(item.id)) + '"><h2>进店看看</h2></a>\n' +
                            '        </div>\n' +
                            '    </div>\n' +
                            '</li>')
                        count++;
                    });

                    if (count % 4 !== 0) {
                        for (var i = 0; i < 4 - count % 4; i++) {
                            lis.push('<li class="single-member effect-3">\n' +
                                '</li>')
                        }
                    }

                    //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                    //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                    next(lis.join(''), page < res.pages);
                });
            }
        });
    });

    function addOrder(e) {
        event.preventDefault();
        layer.open({
            title: '确认添加购物栏？' //显示标题栏
            , id: 'LAY_layuipro' //设定一个id，防止重复弹出
            , offset: '100px'
            , btn: ['确认']
            , closeBtn: 1
            , yes: function (index, layero) {
                //按钮【按钮一】的回调
                var lockIndex = layer.load(1);//
                $.ajax({
                    url: '/food/addOrder.do',
                    data: {foodId: e},
                    type: 'POST',//默认以get提交，以get提交如果是中文后台会出现乱码
                    dataType: 'json',
                    success: function (obj) {
                        layer.msg(obj.msg);
                        var index = layer.getFrameIndex("LAY_layuipro");
                        layer.close(index);
                        layer.close(lockIndex);//关闭
                    }
                });
            }
        });
    }
</script>
</body>
</html>



