// 项目JS主入口
layui.use(['layer','form','element','jquery'],function(exports){
	var layer = layui.layer,
	form = layui.form,
	$ = layui.$;
	// 设置iframe的高度
	// debugger
	// $('#mainIframe').height($('.layui-body').height()-40);
	$('.tab > li').click(function(){
		$(this).addClass('active').siblings('li').removeClass('active');
		$(this).find('.arrow-down').addClass('selected');
		$(this).siblings('li').find('.arrow-down').removeClass('selected');
	});
	$('.layui-nav-item > a').click(function(){
		var _this = $(this),
		hasSelected = _this.closest('li').hasClass('layui-nav-itemed');
		hasSelected ? _this.addClass('one-level-selected') : _this.removeClass('one-level-selected');
	});
	$(document).on('click','.layui-nav-child a',function () {
		var _this = $(this),
			navChildTitle = _this.text();
			navTitle = _this.closest('.layui-nav-item').find('.one-level').text();
		$('.nav-item').text(navTitle);
		$('.nav-item-child').text(navChildTitle);
    });
});