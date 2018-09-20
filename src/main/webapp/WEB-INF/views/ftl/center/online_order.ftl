<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="${basePath}/css/public.css">
	<link rel="stylesheet" href="${basePath}/css/center.css">
</head>
<style>
	.zichan{
		margin-top:0;
		padding-left:0;
	}
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
		    padding: 0.2rem 0.1rem;
    border-bottom: 1px solid #ccc;
	}
	
	tbody {
		color: #333333c7;
	}
	
	
</style>
<body>
	<header>
		<a onclick="window.history.back()"><em>&#xe678;</em></a>
		<span>线上订单</span>
	</header>
	
	<ul class="zichan">
		<table>
			<thead>
				<tr>
					<td style="width:10%">订单号</td>
					<td style="width:35%">下单时间</td>
					<td style="width:30%">发货时间</td>
					<td style="width:15%">状态</td>
				</tr>
			</thead>
		</table>
	</ul>
	
	<ul class="zichan">
		<table>
			<tbody>
				<#list data as order>
					<tr onclick="window.location.href='toDetail/onlineOrder/${order.oid}'">
						<td style="width:10%">${order.oid}</td>
						<td style="width:35%">${order.orderTime}</td>
						<td style="width:30%">
							<#if order.deliverTime == null>
								-
							<#else>
								${order.deliverTime}
							</#if>
						</td>
						<td style="width:15%">
							<#if order.status = 0>
								已生成
							<#elseif order.status = 1>
								待完成
							<#else>	
								完成
							</#if>
						</td>
					</tr>				
				</#list>
			</tbody>
		</table>
	</ul>
</body>
<script src="${basePath}/js/rem.js"></script>
</html>