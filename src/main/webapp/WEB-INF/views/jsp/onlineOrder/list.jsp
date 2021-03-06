<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>线上订单列表</title>
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
		<div class="search-body">
			<div class="search-box">
				<span>关键字：</span>
				<input type="text" id="phone" placeholder="会员号" value="">
				<input type="text" id="orderTime" placeholder="下单时间" value="">
				<input type="text" id="deliverTime" placeholder="发货时间" value="">
			</div>
			<div class="timeBox">
				<span class="btn btn-info" onclick="settings.ajaxSearch()">搜索</span>
			</div>
		</div>
		<div class="portlet-body">
			<table class="table table-striped table-hover table-bordered" id="sample_editable_1">
				<thead>
					<tr>
						<th>订单号</th>
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
			<a class="cek detail detail-btn">详情</a>
		</td>
	</tr>
</script>

	<div class="modal fade" style="display:none" id="detail-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">订单详情</h4>
	      </div>
	      <div class="modal-body" id="detailFill">

	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	      </div>
	    </div>
	  </div>
	</div>
	
		      	 <script id="detailInfo" type="text/x-jsrender">
				<table  style='width:100%'>
					<tr>
						<td>订单号</td>
						<td>{{:oid}}</td>
					</tr>
					<tr>
						<td>手机号</td>
						<td>{{:phone}}</td>
					<tr>
					<tr>
						<td>地址</td>
						<td>{{:address}}</td>
					</tr>
					<tr>
						<td>下单时间</td>
						<td>{{:orderTime}}</td>
					</tr>
					<tr>
						<td>发货时间</td>
						<td>{{:deliverTime}}</td>
					</tr>
					<tr>
						<td>状态</td>
						<td>
							{{if status == 1}}
								待完成
							{{else}}		
								已完成
							{{/if}}
						</td>
					</tr>
				</table>

				<table style='width:100%'>
					
					<tbody>
						<tr>
							<td>商品名称</td>
							<td>原价</td>
							<td>折后价</td>
							<td>数量</td>
						</tr>
						{{for orderSubDetails}}
							<tr>
								<td>{{:productName}}</td>
								<td>{{:originPrice}}</td>
								<td>{{:discountPrice}}</td>
								<td>{{:num}}</td>
							</tr>
						{{/for}}
					</tbody>
				</table>
		
				<table style='font-weight:800;width:100%'>
					<tr>
						<td  style='width:40%'>总价</td>
						<td>{{:normalPrice}}</td>
					<tr>
					<tr>
						<td>折后总价</td>
						<td>{{:memberPrice}}</td>
					</tr>
				</table>
			 </script>
</body>
<script type="text/javascript" src="/js/jsrender.js"></script>
<script type="text/javascript" src="/js/back/onlineOrder/setting.js"></script>
<script src="/js/jquery.hisform.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
$(function(){

	settings.init();

});

$(document).on('click', '.detail-btn', function() {
	var urlStr = "/backstage/onlineOrder/ajaxLoadDetail/" + $(this).parents('tr').find('.oid').val();
	$.ajax({
        type : "POST",
        url : urlStr,
        success:function (data) {
 	   	   if(data.returncode==0){
	 	   		var detailInfo = $.templates('#detailInfo');
				var detail = detailInfo.render(data.data[0]);
				$("#detailFill").html(detail);
 	   			$('#detail-modal').modal('show');
 	   	   }else{                   	   
 	   			layer.alert('获取数据失败！', {icon: 6});
 	   	   }              
 	    },
 	    error: function (error) { 
 	    	layer.msg('网络连接失败', {icon: 1}); 
 	    }
    });
	
});


</script>
</html>