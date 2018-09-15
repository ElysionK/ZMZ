$(function(){
	var allVal='';
	//email blur
	$("input[name='phone']").blur(function(allVal){
		var phoneNumRegular =  /^1\d{10}$/;
		var phone = $(this).val();
		if(phoneNumRegular.test(phone)){
			allVal='格式正确';
		}else if(userPhone == ''){
			allVal='手机号不能为空';
			layerOpen(allVal);
		}else{
			allVal='您填写的手机号格式不正确';
			layerOpen(allVal);
		}
	});
	
	//password blur
	$("input[name='password']").blur(function(allVal){
		var paswVal = $(this).val();
		if(paswVal.length == ''){
			allVal='密码不能为空';
			layerOpen(allVal);
		}
	});
	
	$("input[name='registCode']").blur(function(allVal){
		var paswVal = $(this).val();
		if(paswVal.length == ''){
			allVal='注册码不能为空';
			layerOpen(allVal);
		}
	});
	
	//login button
	$("#login-btn").on('click',function(){
		 layer.open({
			type: 2
			,content: '登录中...'
			,time: 2
		 });
	});
	
	$("#regist-btn").on('click',function(){
		 layer.open({
			type: 2
			,content: '注册中...'
			,time: 2
		 });
	});
	
	//general layer
	function layerOpen(allVal){
		console.log(allVal);
		layer.open({
			content: allVal,
			btn: '确定'
		});
	}
	
	$('#login-btn').on('click', function() {
		$("#login-form").ajaxSubmit({
		    url: "/open/login",
		    type: "post",
			dataType: "json",
		    success:function (data) {
		   	   if(data.returncode==0){
		   		   window.location.href="/index"
		   	   }else{                   	   
		   		   layerOpen(data.errmsg);
		   	   }              
		    },
		    error: function (error) { 
		    	layerOpen('网络连接失败'); 
		    }
		});
	});
	
	$('#regist-btn').on('click', function() {
		$("#regist-form").ajaxSubmit({
		    url: "/open/regist",
		    type: "post",
			dataType: "json",
		    success:function (data) {
		   	   if(data.returncode==0){
			   		layerOpen('注册成功');
			   		window.location.href="/open/toLogin"
		   	   }else{                   	   
		   		   layerOpen(data.errmsg);
		   	   }              
		    },
		    error: function (error) { 
		    	layerOpen('网络连接失败'); 
		    }
		});
	});
});