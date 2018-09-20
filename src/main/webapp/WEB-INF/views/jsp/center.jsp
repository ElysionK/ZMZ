<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <title>个人中心</title>
<%@include file="./public/head.jsp" %>
</head>

<style>
	label {
		margin-right: 15px;
	}
	
	.form-group {
		padding-top: 20px;
	}
	
	
	input[type="password"] {
		height: 25px;
	}
	
	#upd-btn {
		background: #00b0ea;
		color: #fff;
		width: 250px;
    	margin-left: 130;
	}
	
	.form-horizontal {
		margin-top: 50px;
		margin-left: 450px;
	}
</style>
<body>
<div class="page-container">
	<%@include file="./public/leftMenu.jsp" %>
	
    <div class="form-horizontal">
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">账号</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="name" 
					   placeholder="请输入账号" value="${admin.name}">
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">密码</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="password" 
					   placeholder="请输入密码" value="${admin.password}">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button id="upd-btn" class="btn btn-default" onclick="updAdminInfo()">确定</button>
			</div>
		</div>
	</div>
    
	<%@include file="./public/footer.jsp" %>
</div>
</body>

<script>
function updAdminInfo() {
	var name = $('#name').val(), password = $('#password').val();
	if ((name == '' || name == undefined) && (password == '' || password == undefined)) {
		alert('账号和密码不能同时为空');
		return;
	}
	
	var dataJSON = JSON.stringify(
		{
			"name": name,
			"password": password
		}
	);
	$.ajax({
        type : "POST",
        url : "/backstage/modify/adminInfo",
        data : dataJSON,
        dataType : "json",
        contentType : "application/json; charset=utf-8",
        success:function (data) {
 	   	   if (data.returncode == 0) {
 	   		   alert('修改成功');
 	   	   } else {
 	   		   alert('修改失败');
 	   	   }
 	    },
 	    error: function (error) { 
 	    	alert('网络连接失败'); 
 	    }
    });
}
</script>
</html>