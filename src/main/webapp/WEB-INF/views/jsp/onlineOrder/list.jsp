<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>线下订单列表</title>
	<%@include file="../public/head.jsp" %>
	<link href="/css/back/category.css" rel="stylesheet" type="text/css" />
	<link href="/css/setup.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page-container">
	<%@include file="../public/leftMenu.jsp" %>
	<div class="page-content">
		<div class="contenttop">
			<div class="tit">线上订单列表</div>
		</div>
		
		<div class="portlet-body">
			<table class="table table-striped table-hover table-bordered" id="sample_editable_1">
				<thead>
					<tr>
						<th>序号</th>
						<th>会员号</th>
                        <th>下单时间</th>
                        <th>发货时间</th>
                        <th>状态</th>
                        <th>操作</th>
					</tr>
				</thead>
				<tbody id="orderFill">
					
				</tbody>
			</table>
		</div>
		<%@include file="../public/ajaxPagination.jsp" %>
	</div>
	<%@include file="../public/footer.jsp" %>
</div>
<script id="orderInfo" type="text/x-jsrender">
	<tr>
		<input type="hidden" class="oid" value="{{:oid}}">
		<td>{{:oid}}</td>
		<td>{{:phone}}</td>
		<td>{{:orderTime}}</td>
		<td>{{:deliverTime}}</td>
		<td>
			{{if status = 1}}
				待完成
			{{else}}
				完成
			{{/if}}
		</td>
		<td>
			<a class="cek detail del-btn">删除</a>
			<a class="cek detail detail-btn">详情</a>
		</td>
	</tr>
</script>

	<div class="modal fade" style="display:none" id="batchUploadModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">订单详情</h4>
	      </div>
	      <div class="modal-body">
	      	 <form class="" id="batch-upload-form" enctype="multipart/form-data">
		        <table class="table table-bordered table-hover m10" style="width:90%;">
	                 <tbody>
	                     <tr>
	                         <td>
	                             <input type="file" name="excel" accept="application/vnd.ms-excel,application/x-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
	                         </td>
	                     </tr>
	                  </tbody>
	             </table>
	         </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="upload-btn">确定</button>
	      </div>
	    </div>
	  </div>
	</div>
</body>
<script type="text/javascript" src="/js/jsrender.js"></script>
<script type="text/javascript" src="/js/back/onlineOrder/setting.js"></script>
<script src="/js/jquery.hisform.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
$(function(){

	settings.init();

});

$(document).on('click', '.add-btn', function() {
	$('#batchUploadModal').modal('show')
});

$(document).on('click', '#upload-btn', function() {
	$("#batch-upload-form").ajaxSubmit({
	    url: "/backstage/offlineOrder/upload",
	    type: "post",
		dataType: "json",
	    success:function (data) {
	   	   if(data.returncode==0){
	   	   		layer.alert('导入成功！', {icon: 6});
	   	   		$('#upload-btn').modal('hide');
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

$(document).on('click', '.del-btn', function() {
	alert(urlStr);
	layer.open({
		content: '确定删除',
		btn: ['确定', '取消'],
		yes: function(index, layero){
			$.ajax({
		        type : "POST",
		        url : urlStr,
		        success:function (data) {
		 	   	   if(data.returncode==0){
		 	   	   		layer.alert('删除成功！', {icon: 6});
		 	   	   		setTimeout(function(){
		 	   	   			window.location.reload();
		 	    		},1000);
		 	   	   }else{                   	   
		 	   			layer.alert('删除失败！', {icon: 6});
		 	   	   }              
		 	    },
		 	    error: function (error) { 
		 	    	layer.msg('网络连接失败', {icon: 1}); 
		 	    }
		    });
		 },
		 btn2: function(index, layero) {
			 layer.close();
		 }
	});
	
});
	
</script>
</html>