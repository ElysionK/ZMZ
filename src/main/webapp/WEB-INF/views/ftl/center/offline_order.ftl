<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="${basePath}/css/public.css">
	<link rel="stylesheet" href="${basePath}/css/center.css">
</head>
<style>

	body{
		background-color: #fff;
	}
	header{
		width: 100%;
		background-color: #fff;
		height: 0.72rem;
		padding-left: 0.23rem;
		position: relative;
	}
	header em{
		font-size: 0.26rem;
		float: left;
		line-height: 0.72rem;
		color: #666;
		font-family: 'iconfont';
	}
	header:after{
		content: '';
		width: 0.01rem;
		height: 0.18rem;
		background-color: #ccc;
		position: absolute;
		top: 0.27rem;
		left: 0.68rem;
	}
	header>span{
		font-size: 0.2rem;
		color: #333;
		float: left;
		line-height: 0.72rem;
		margin-left: 0.33rem;
	}
	table {
		font-size: 0.17rem;
    	color: #333;
    	width: 100%;
    	padding-top: 0.1rem;
    	padding-bottom: 0.1rem;
    	text-align: center;
	}
	
	tr {
		height: 0.35rem;
	}
	
	td {
		margin-left: 0.1rem;
	    float: left;
	}
	
	tbody {
		color: #333333c7;
	}
	
	
</style>
<body>
	<header>
		<a onclick="window.history.back()"><em>&#xe678;</em></a>
		<span>线下订单</span>
	</header>
	
	<ul class="zichan">
		<table>
			<thead>
				<tr>
					<td style="width:30%">日期</td>
					<td style="width:30%">产品名称</td>
					<td style="width:30%">数量</td>
				</tr>
			</thead>
			<tbody>
				<#list data as order>
					<tr onclick="window.location.href='toDetail/offlineOrder/${order.id}'">
						<td style="width:30%">${order.date}</td>
						<td style="width:30%">${order.productName}</td>
						<td style="width:30%">${order.num}</td>
					</tr>				
				</#list>
			</tbody>
		</table>
	</ul>
</body>
<script src="${basePath}/js/rem.js"></script>
</html>