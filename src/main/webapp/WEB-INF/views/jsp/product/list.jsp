<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>套餐列表</title>
	<%@include file="../public/head.jsp" %>
	<link href="/css/back/category.css" rel="stylesheet" type="text/css" />
	<link href="/css/setup.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page-container">
	<%@include file="../public/leftMenu.jsp" %>
	<div class="page-content">
		<div class="contenttop">
			<div class="tit">套餐列表</div>
		</div>
		<div class="search-body">
			<div class="search-box">
				<span>关键字：</span>
				<input type="text" id="name" placeholder="商品名称" value="">
				<select id="category" style="margin-top: 8px">
					<option selected="selected">类别</option>
					<c:forEach items="${data}" var="item">
						<option value="${item.id}">${item.name}</option>
					</c:forEach>
				</select>
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
						<td>商品名称</td>
						<th>分类名称</th>
						<th>原价</th>
						<th>折扣</th>
                       	<th>图片</th>
                       	<th>简述</th>
                        <th>创建时间</th>
                        <th>操作</th>
					</tr>
				</thead>
				<tbody id="productFill">
					
				</tbody>
			</table>
			<div class="new-add">
				<span class="add-btn" onclick="window.location.href='/backstage/product/add'">新增套餐</span>
			</div>
		</div>
		<%@include file="../public/ajaxPagination.jsp" %>
	</div>
	<%@include file="../public/footer.jsp" %>
</div>
<script id="productInfo" type="text/x-jsrender">
	<tr>
		<td>{{:id}}</td>
		<td>{{:name}}</td>
		<td>{{:categoryName}}</td>
		<td>{{:orignalPrice}}</td>
		<td>{{:discountPrice}}</td>
		<td><img alt="套餐图片" src="${pageContext.request.contextPath}/upload/{{:img}}" style="width: 35px;"></td>
		<td>{{:brief}}</td>
		<td>{{:createTime}}</td>
		<td><a class="cek detail" href="javascript:void(0)">修改</a></td>
	</tr>
</script>
</body>
<script type="text/javascript" src="/js/jsrender.js"></script>
<script type="text/javascript" src="/js/back/product/setting.js"></script>
<script type="text/javascript">
$(function(){

	settings.init();

});
</script>
</html>