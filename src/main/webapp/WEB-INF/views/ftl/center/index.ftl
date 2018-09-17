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
		<h1>${data.phone}</h1>
		<div>
			<a javascript="void(0)"><p>退出</p></a>
		</div>
	</header>
	<ul class="server">
		<li>
			<em>&#xe656;</em>
			<a href="onlineOrder"><span>线上订单</span></a>
		</li>
		<li>
			<em>&#xe87e;</em>
			<a href="offlineOrder"><span>线下订单</span></a>
		</li>
	</ul>
	
	<ul class="zichan">
		<h1>最近线上订单</h1>
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
					<tr onclick="window.location.href='toDetail/onlineOrder/${order.oid}'">
						<td style="width:10%">${order.oid}</td>
						<td style="width:35%">${order.orderTime}</td>
						<td style="width:35%">
							<#if order.deliverTime == null>
								-
							<#else>
								${order.deliverTime}
							</#if>
						</td>
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
		<h1>最近线下订单</h1>
		<table>
			<thead>
				<tr>
					<td style="width:30%">日期</td>
					<td style="width:30%">产品名称</td>
					<td style="width:30%">数量</td>
				</tr>
			</thead>
			<tbody>
				<#list data.offlineOrders as order>
					<tr onclick="window.location.href='toDetail/offlineOrder/${order.id}'">
						<td style="width:30%">${order.date}</td>
						<td style="width:30%">${order.productName}</td>
						<td style="width:30%">${order.num}</td>
					</tr>				
				</#list>
			</tbody>
		</table>
	</ul>
	<#include "/public/menu.ftl" />
</body>
<script src="${basePath}/js/rem.js"></script>
</html>