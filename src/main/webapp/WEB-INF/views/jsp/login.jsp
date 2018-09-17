<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
		<title>管理员登录</title>
		<link href="${ bathPath }/css/login.css" rel="stylesheet">
		<link href="${ bathPath }/css/self_bt.css" rel="stylesheet">
		<link href="${ bathPath }/css/signin.css" rel="stylesheet">
		
		<style type="text/css">
			.login-content {
				position: relative;
				background-color: #fff;
				border: 1px solid #fff;
				border-radius: 6px;
				background-clip: padding-box;
				outline: none
			}
			.login-modal-header {
				min-height: 16.42857143px;
				text-align: center;
			}
		</style>
	</head>

	<body style="background: url(${ basePath }/images/zlogin.jpg)">
		<div class="login-content"
					style="width: 400px; height: 350px;  margin-left: 150px; margin-top: 160px; padding: 10px">
			<div class="login-modal-header" style="margin-top: 30px">
				<h3 style="font-weight: normal; font-size: 26px; color: #666666;">
				管理员登录
				</h3>
			</div>
			<div>
				<div class="form-signin">
					<input type="text" id="name" class="signin-form-control"
						placeholder="请输入管理员账号" required>
					<div style="height: 30px">
					</div>
					<input type="password" id="password"
						class="signin-form-control" placeholder="请输入管理员密码" required>
					<button class="btn btn-lg btn-primary btn-block" style="margin-top:20px" id="login-btn">
						登录
					</button>
				</div>
			</div>
		</div>
		
		
	</body>
	<script src="${ basePath }/js/jquery-2.0.0.min.js"></script>
	<script src="${ basePath }/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	$(document).on('click', '#login-btn', function() {
		var name = $("#name").val(), password = $("#password").val();
		if ((name == '' || name == undefined) || (password == '' || password == undefined)) {
			alert('账号和密码不能为空');
			return;
		}
		var dataJSON = JSON.stringify({
				"name": name,
				"password": password
			}); 
		$.ajax({
	        type : "POST",
	        url : "/backstage/adminLogin",
	        data : dataJSON,
	        dataType : "json",
	        contentType : "application/json; charset=utf-8",
	        success:function (data) {
	 	   	   if (data.returncode == 0) {
	 	   		   window.location.href="/backstage/index";
	 	   	   } else {
	 	   		   alert('登录失败，账号或密码有误');
	 	   	   }
	 	    },
	 	    error: function (error) { 
	 	    	alert('网络连接失败'); 
	 	    }
	    });
		
	});
	</script>
</html>