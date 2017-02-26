
/* noty 弹出框的默认设置------------------------*/
$.noty.defaults = {
    layout: 'bottomRight',  // 默认布局
    theme: 'defaultTheme', // 默认主题
    type: 'alert', // 默认类型
    text: '', //默认文本
    dismissQueue: true, // 是否添加到队列
    template: '<div class="noty_message"><span class="noty_text"></span><div class="noty_close"></div></div>',  // 消息默认模板
    animation: { //默认的显示及关闭动画
        open: {height: 'toggle'},
        close: {height: 'toggle'},
        easing: 'swing',
        speed: 500 // opening & closing animation speed
    },
    timeout: 2000, // 自动关闭时间,默认不会自动关闭
    force: false, // 添加到队列开始处
    modal: false, // 遮罩
    maxVisible: 5, // 一个队列的消息最大可见数量, 即一个队列中同一时间最多显示的数量
    closeWith: ['click'], // ['click', 'button', 'hover'] 关闭的事件,默认点击消息关闭
    callback: { // 回调函数
        onShow: function() {}, // 显示之前
        afterShow: function() {}, // 显示之后
        onClose: function() {}, // 关闭之前
        afterClose: function() {
        	// 关闭之后，清空result 里面的值
        	// <% request.setAttribute("result", null); %>
        } // 关闭之后
    },
    buttons: false // 按钮,用于在弹出的消息框中显示按钮
};
/* 访问页面，并且填充------------------------*/

$(function(){
	//jQuery validte 方式的输入验证
	//$("form.kr_validate").validate();//也是不支持模态框
	
	
	//bootstrap validator 方式的输入验证
	//$("form.kr_validate") //data 方式不可行。因为只是塞入数据罢了。并不会在html 里面真的塞入HTML 内容
			//.data("bv-feedbackicons-valid", "glyphicon glyphicon-ok")
			//.data("data-bv-feedbackicons-valid", "glyphicon glyphicon-ok")//其实data 方法自动会帮你前面加入“data-”
			//.data("bv-feedbackicons-invalid", "glyphicon glyphicon-remove")
			//.data("bv-feedbackicons-validating", "glyphicon glyphicon-refresh")
			//.bootstrapValidator();  //虽然数据data数据可以放进去，也可以拿出来，但是还是对bootstrapValidator 的初始化不起作用
	
	$("form.kr_validate")//.attr("data-bv-message", "This value is not valid")
		.attr("data-bv-feedbackicons-valid", "glyphicon glyphicon-ok")
		.attr("data-bv-feedbackicons-invalid", "glyphicon glyphicon-remove")
		.attr("data-bv-feedbackicons-validating", "glyphicon glyphicon-refresh")
		.bootstrapValidator(); //用attr 的方式可行！！虽然也没有实际把HTML 加入，但是就是可行。

	//输入框内容转移到fckeditor
	$.copyContent = function (){
		var content = $("#content").val();
		$("#advanced_content").val(content);
	};
	
	
    // 下拉选择框，增加select2 的效果
	$(".select2").select2({
		language: 'zh-CN'
	});//如果是模态框，必须在自己的页面去调用开启
    
    // 打开tooltip 开关
    $('[data-toggle="tooltip"]').tooltip();
    
  //弹出操作确认框
    $.kr_confirm = function(url, text){
        
        var options = {
        //message: typeof(text) == "undefined"? "Are you sure?" : text,
        message: !text ? "Are you sure?" : text,// 中间的内容
        title: '操作确认',// 上方的标题
        size: eModal.size.sm,// 弹出框的大小：'sm' | 'lg' | 'xl'
        //subtitle: '操作确认', // 设置小文本的情况下的标题
        label: "Yes"   // label: 'Yes' | 'True'| 'OK'
    };
        eModal.confirm(options).then(function(){
            //url = url +"&t=" + new Date();//加date 是为了避免浏览器读取缓存信息。一般用在浏览
            window.location.href = url;
        }, function(){
        	// 这里写用户点击取消按钮的时候的，回调函数
        });
    };//end -----------kr_confirm
    
    // eModal 调用 ajax 方法，并用模态框显示
    $.kr_detail = function(url, title){
    	var options = {
    			url: url,
    	        title: !title ? "详情" : title,// 上方的标题
    	        size: eModal.size.lg,// 弹出框的大小：'sm' | 'xl' | 'lg'
    	    };
    	
    	eModal.ajax(options);
    };//end ---------$.kr_detail
    
    // eModal 用模态框展示，操作的form
    $.kr_form = function(url, formId, title, size){
    	if(formId){
    		formId = "#" + formId;
    	}
    	var options = {
    			url: url,
    	        title: !title ? "操作" : title,// 上方的标题
    	        size: size ? size : "xl",// 弹出框的大小：'sm' | 'xl' | 'lg'
    	        buttons: [
    	                  {text: '取消', style: 'default', close: true, click: function(){
    	                	  // 点击取消按钮
    	                  } },
    	                  {text: '确认', style: 'primary',   close: true, click: function(){
    	                	  // 点击确认按钮
    	                	  // 提交form 表单
    	                	  $(formId).submit();
    	                  } }
    	              ]
    	    };
    	
    	eModal.ajax(options);
    };// end ---------$.kr_form
    
    // 返回顶部
	$(window).scroll(function() {
		var sc = $(window).scrollTop();
		var rwidth = $(window).width();
		if (sc > 160) {
			//$("#goTopBtn").css("display","block");
			$("#goTopBtn").fadeIn(400);
			$("#goTopBtn").css("left", (rwidth - 70) + "px");
		} else {
			//$("#goTopBtn").css("display","none");
			$("#goTopBtn").fadeOut(400);
		}
	});
	$("#goTopBtn").click(function() {
		//var sc = $(window).scrollTop();
		$('body,html').animate({
			scrollTop : 0
		}, 400);
	});

	$("#goTopBtn").hover(function() {
		$("#goTopBtn").css("background-color", "#000").css("color", "#FFF");//.css("border-color","#000");
		//$("#goTopBtn").css("opacity", "1.0");
	}, function() {
		$("#goTopBtn").css("background-color", "#337AB7").css("color", "#FFF");//.css("border-color","#337AB7");//鼠标离开复原css
		//$("#goTopBtn").css("opacity", ".7");
	});
    
});
