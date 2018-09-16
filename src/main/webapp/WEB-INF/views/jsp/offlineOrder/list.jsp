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
			<div class="tit">线下订单列表</div>
		</div>
		
		<div class="portlet-body">
			<table class="table table-striped table-hover table-bordered" id="sample_editable_1">
				<thead>
					<tr>
						<th>序号</th>
						<th>会员号</th>
						<th>商品名称</th>
						<th>原单价</th>
						<th>原价总金额</th>
                       	<th>会员单价</th>
                       	<th>会员总金额</th>
                        <th>优惠单价</th>
                        <th>优惠总金额</th>
                        <th>数量</th>
                        <th>日期</th>
                        <th>操作</th>
					</tr>
				</thead>
				<tbody id="orderFill">
					
				</tbody>
			</table>
			<div class="new-add">
				<span class="add-btn">批量导入</span>
			</div>
		</div>
		<%@include file="../public/ajaxPagination.jsp" %>
	</div>
	<%@include file="../public/footer.jsp" %>
</div>
<script id="orderInfo" type="text/x-jsrender">
	<tr>
		<td>{{:id}}</td>
		<td>{{:memberNo}}</td>
		<td>{{:productName}}</td>
		<td>{{:orignalPrice}}</td>
		<td>{{:totalOrignalPrice}}</td>
		<td>{{:memberPrice}}</td>
		<td>{{:totalMemberPrice}}</td>
		<td>{{:preferentialPrice}}</td>
		<td>{{:totalPreferentialPrice}}</td>
		<td>{{:num}}</td>
		<td>{{:date}}</td>
		<td>
			<a id="{{:id}}" class="cek detail del-btn">删除</a>
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
			<a class="cek detail" href="javascript:void(0)">修改</a>
>>>>>>> a656f0fd398429cbc4355a9fb2981e1567f7f9a3
>>>>>>> d981aaa1ab0969294b0ed70f0981c20a8daff1e1
		</td>
	</tr>
</script>

	<div class="modal fade" style="display:none" id="batchUploadModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">批量导入</h4>
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
<script type="text/javascript" src="/js/back/offlineOrder/setting.js"></script>
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