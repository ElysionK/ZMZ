<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="${basePath}/css/public.css">
	<link rel="stylesheet" href="${basePath}/css/center.css">
</head>
<style>
	table {
		font-size: 0.16rem;
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
		<div class="head_top">
			
		</div>
		<a href="resource.html"><img src="../../../../images/Screenshot_2018-04-17-15-12-11-01_03.png" alt=""></a>
		<h1>${data.user.phone}</h1>
		<div>
			<a javascript="void(0)"><p>退出</p></a>
		</div>
	</header>
	<ul class="server">
		<li>
			<em>&#xe656;</em>
			<span>线上订单</span>
		</li>
		<li>
			<em>&#xe87e;</em>
			<span>线下订单</span>
		</li>
	</ul>
	
	<ul class="zichan">
		<h1>线上订单(最近三天)</h1>
		<table>
			<thead>
				<tr>
					<td style="width:10%">订单号</td>
					<td style="width:35%">下单时间</td>
					<td style="width:35%">发货时间</td>
					<td style="width:10%">状态</td>
				</tr>
			</thead>
			<tbody>
				<#list data.onlineOrders as order>
					<tr>
						<td style="width:10%">${order.oid}</td>
						<td style="width:35%">${order.orderTime}</td>
						<td style="width:35%">${order.deliverTime}</td>
						<td style="width:10%">
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
	
	<ul class="zichan">
		<h1>线下订单(最近三天)</h1>
		<table>
			<thead>
				<tr>
					<td style="width:10%">订单号</td>
					<td style="width:35%">下单时间</td>
					<td style="width:35%">发货时间</td>
					<td style="width:10%">状态</td>
				</tr>
			</thead>
			<tbody>
				<#list data.onlineOrders as order>
					<tr>
						<td style="width:10%">${order.oid}</td>
						<td style="width:35%">${order.orderTime}</td>
						<td style="width:35%">${order.deliverTime}</td>
						<td style="width:10%">
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
	<#include "/public/menu.ftl" />
</body>
<script src="${basePath}/js/rem.js"></script>
</html>