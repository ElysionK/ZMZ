<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>注册用户列表</title>
	<%@include file="../public/head.jsp" %>
	<link href="/css/back/category.css" rel="stylesheet" type="text/css" />
	<link href="/css/setup.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page-container">
	<%@include file="../public/leftMenu.jsp" %>
	<div class="page-content">
		<div class="contenttop">
			<div class="tit">注册用户列表</div>
		</div>
		<div class="search-body">					
			<div class="search-box">
				<span>关键字：</span>
				<input type="text" id="phone" placeholder="会员号" value="">
				<input type="text" id="registTime" placeholder="注册时间" value="">
			</div>
			<div class="timeBox">
				<span class="btn btn-info" onclick="settings.ajaxSearch()">搜索</span>
			</div>
		</div>
		<div class="portlet-body">
			<table class="table table-striped table-hover table-bordered" id="sample_editable_1">
				<thead>
					<tr>
						<th>序号</th>
						<th>会员号</th>
						<th>注册时间</th>
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
		<td>{{:id}}</td>
		<td>{{:phone}}</td>
		<td>{{:registTime}}</td>
	</tr>
</script>

	</body>
<script type="text/javascript" src="/js/jsrender.js"></script>
<script type="text/javascript" src="/js/back/user/setting.js"></script>
<script src="/js/jquery.hisform.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
$(function(){

	settings.init();

});

	
</script>
</html>