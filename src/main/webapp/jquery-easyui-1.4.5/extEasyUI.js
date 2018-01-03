var dewell = $.extend({}, dewell);


function getTop(){
	var screenWidth = window.innerWidth;//$(window).height(); jquery 1.7 之后就不行了 
	var screenHeight = window.innerHeight; //当前浏览器窗口的 宽高   
	var scrolltop = $(document).scrollTop();//获取当前窗口距离页面顶部高度   
	var objLeft = (screenWidth - 500)/2 ;   
	var objTop = (screenHeight - 650)/2 + scrolltop;
	return objTop;
	}


dewell.dialog = function(options,id) {
	var opts = $.extend({
		modal : true,
		onClose : function() {
			$(this).dialog('destroy');
		},
		top:getTop()
	}, options);
	var div='<div id="'+id+'"  />';
	return $(div).dialog(opts);
};