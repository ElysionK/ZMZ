<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>注册码列表</title>
	<%@include file="../public/head.jsp" %>
	<link href="/css/back/category.css" rel="stylesheet" type="text/css" />
	<link href="/css/setup.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page-container">
	<%@include file="../public/leftMenu.jsp" %>
	<div class="page-content">
		<div class="contenttop">
			<div class="tit">注册码列表</div>
		</div>
		
		<div class="portlet-body">
			<table class="table table-striped table-hover table-bordered" id="sample_editable_1">
				<thead>
					<tr>
						<th>序号</th>
						<td>注册码</td>
						<th>状态</th>
						<th>用户</th>
					</tr>
				</thead>
				<tbody id="registCodeFill">
					
				</tbody>
			</table>
			<div class="new-add">
				<span class="add-btn" >新增注册码</span>
			</div>
		</div>
		<%@include file="../public/ajaxPagination.jsp" %>
	</div>
	<%@include file="../public/footer.jsp" %>
</div>
<script id="registCodeInfo" type="text/x-jsrender">
	<tr>
		<td>{{:id}}</td>
		<td>{{:registCode}}</td>
		<td>
			{{if status = 1}} 
				有效
			{{else}}
				无效
			{{/if}}
		</td>
		<td>{{:userPhone}}</td>
	</tr>
</script>

	<!-- add registCode modal -->
	<div class="modal fade" style="display:none" id="genCodeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">添加注册码</h4>
	      </div>
	      <div class="modal-body">
	        <table class="table table-bordered table-hover m10" style="width:90%;">
                 <tbody>
                     <tr>
                         <td width="15%">注册码数量</td>
                         <td>
                             <input type="number" id="code-count" name="codeCount" min="1" step="1" datatype="*" nullmsg="请输入注册码数量" maxlength="50">
                             <span class="Validform_checktip"></span>
                         </td>
                     </tr>
                  </tbody>
             </table>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="gen-code-btn">确定</button>
	      </div>
	    </div>
	  </div>
	</div>
	

</body>
<script type="text/javascript" src="/js/jsrender.js"></script>
<script type="text/javascript" src="/js/back/registCode/setting.js"></script>
<script type="text/javascript">
$(function(){

	settings.init();

});

$(document).on('click', '.add-btn', function() {
	addRegistCode(this);
});

function addRegistCode(that) {
	showModal('genCodeModal');
}

$(document).on('click', '#gen-code-btn', function() {
	$.ajax({
        type : "POST",
        url : "/backstage/registCode/add/" + $('#code-count').val(),
        success:function (data) {
 	   	   if(data.returncode==0){
 	   	   		layer.alert('添加成功！', {icon: 6});
 	   	   		$('#genCodeModal').modal('hide');
 	   	   		setTimeout(function(){
 	   	   			window.location.reload();
 	    		},1000);
 	   	   }else{                   	   
 	   	   		layer.msg(data.errmsg);
 	   	   }              
 	    },
 	    error: function (error) { 
 	    	layer.msg('网络连接失败', {icon: 1}); 
 	    }
    });

});

function showModal(modalId) {
	//获取modal的宽度
	var modalWidth = $("#" + modalId).width();
	//计算偏移量
	var left = "-" + parseInt(modalWidth) / 2 + "px";
	//modal居中
	$('#' + modalId).modal('show').css({"margin-left":left});
}

</script>
</html>