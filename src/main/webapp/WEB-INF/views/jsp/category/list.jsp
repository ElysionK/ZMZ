<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>个人体检套餐列表</title>
	<%@include file="../public/head.jsp" %>
	<link href="/css/back/category.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page-container">
	<%@include file="../public/leftMenu.jsp" %>
	<div class="page-content">
		<div class="contenttop">
			<div class="tit">个人体检套餐列表</div>
		</div>
		
		<div class="portlet-body">
			<table class="table table-striped table-hover table-bordered" id="sample_editable_1">
				<thead>
					<tr>
						<th><input type="checkbox" class="checkAll" disabled/></th>
						<th>序号</th>
						<th>分类名称</th>
                       	<th>图片</th>
                        <th>创建时间</th>
                        <th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="list">
						<tr>
							<td><input type="checkbox" class="pids" value=""  data=""/></td>
							<td>${list.sort}</td>
							<td>${list.name}</td>
							<td><img alt="" src="${pageContext.request.contextPath}/upload/${list.img}"></td>
							<td>${list.createtime}</td>
							<td><a class="cek detail" href="javascript:void(0)">修改</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="new-add">
				<span class="add-btn" onclick="window.location.href='/backstage/category/add'">新增</span>
			</div>
			<%@include file="../public/pagination.jsp" %>
		</div>
	</div>
	<%@include file="../public/footer.jsp" %>
</div>
</body>
<script type="text/javascript">
$(function(){


});
</script>
</html>