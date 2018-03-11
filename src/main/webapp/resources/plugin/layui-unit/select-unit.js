// 项目JS主入口
layui.use(['layer', 'form', 'jquery'], function (exports) {
    var layer = layui.layer,
        form = layui.form,
        $ = layui.$;

    //普通下拉框数据回显
    $.ajax({
        url: 'get.do',
        type: 'POST',//默认以get提交，以get提交如果是中文后台会出现乱码
        dataType: 'json',
        success: function (obj) {
            if (obj.success) {
                //获取传参
                var data = obj.obj;
                var body = $("body");

                var inputArray = body.find("input[type='text']");// 取到所有的input text
                var selectArray = body.find("select[class='boolean']");// 取到所有的select boolean
                var selectBoxArray = body.find("select[class='selectBox']");// 取到所有的select selectBox
                inputArray.each(function () {
                    var input = $(this);// 循环中的每一个input元素
                    var name = input.attr("name");
                    if (data[name] != "") {
                        input.val(data[name]);
                    }
                });

                selectArray.each(function () {
                    var select = $(this);// 循环中的每一个select元素
                    var name = select.attr("name");
                    if (data[name] != "") {
                        $(this).html("");
                        $(this).append('<option selected="" value="">请选择</option>');

                        if (data[name] == "0") {
                            $(this).append('<option value="0">否</option>');
                            $(this).append('<option value="1" selected="selected">是</option>');
                        } else {
                            $(this).append('<option value="0" selected="selected">否</option>');
                            $(this).append('<option value="1">是</option>');
                        }
                    }
                });

                initAddressSelect('domain', selectBoxArray, '合肥', '1', 'base')

                form.render();//重新渲染

            } else {
            }
        }
    });

    /**
     * 高德地图行政区查询服务
     * @param form
     * @param selectBoxName
     * @param selectBoxArray
     * @param keywords
     * @param subdistrict
     * @param extensions
     */
    function initAddressSelect(form, selectBoxName, selectBoxArray, keywords, subdistrict, extensions) {
        $.ajax({
            url: 'http://restapi.amap.com/v3/config/district?key=a88d5bcbd829bc9ee66a433a55675801&keywords=' + keywords + '&subdistrict=' + subdistrict + '&extensions=' + extensions,
            type: 'GET',
            dataType: 'json',
            async: true,
            success: function (data) {
                var map = data.districts[0].districts;//返回的地图数据
                selectBoxArray.each(function () {
                    var select = $(this);
                    var name = select.attr("name");
                    if (selectBoxName == name) {
                        $(this).html("");
                        $(this).append('<option selected="" value="">请选择</option>');
                        for (var i = 0; i < map.length; i++) {
                            // if(map[i][name]==value){
                            //     select.append('<option selected="selected" value='+map[i][name]+'>'+map[i][name]+'</option>');
                            // }else{
                            $(this).append('<option value=' + map[i].name + '>' + map[i].name + '</option>');
                            // }
                        }
                        form.render();//数据渲染
                    }
                })
            }
        });
    }

});