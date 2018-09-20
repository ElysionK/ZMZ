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
		<a href="window.history.back()"><em>&#xe678;</em></a>
		<span>订单详情</span>
	</header>
	
	<ul class="zichan">
		<table>
			<tr>
				<td>订单号:</td>
				<td>${data.oid}</td>
			</tr>
			<tr>
				<td>手机号:</td>
				<td>${data.phone}</td>
			</tr>
			<tr>
				<td>地址:</td>
				<td>${data.address}</td>
			</tr>
			<tr>
				<td>下单时间:</td>
				<td>${data.orderTime}</td>
			</tr>
			<tr>
				<td>发货时间:</td>
				<td>${data.deliverTime}</td>
			</tr>
			<tr>
				<td>状态:</td>
				<td>
					<#if data.status == 1>
						待完成
					<#else>		
						已完成
					</#if>
				</td>
			</tr>
		</table>
	</ul>
	<ul class="zichan">
		<table>
			<thead>
				<tr>
					<td style="width:40%;border-top:1px solid #ccc;margin-left:0;padding-top:0.1rem;padding-bottom:0.1rem;">商品名称</td>
					<td style="width:20%;border-top:1px solid #ccc;margin-left:0;padding-top:0.1rem;padding-bottom:0.1rem;">原价</td>
					<td style="width:20%;border-top:1px solid #ccc;margin-left:0;padding-top:0.1rem;padding-bottom:0.1rem;">折后价</td>
					<td style="width:20%;border-top:1px solid #ccc;margin-left:0;padding-top:0.1rem;padding-bottom:0.1rem;">数量</td>
				</tr>
			</thead>
			<tbody>
				<#list data.orderSubDetails as detail>
					<tr>
						<td style="width:40%;border-top:1px solid #ccc;margin-left:0;padding-top:0.1rem;padding-bottom:0.1rem;">${detail.productName}</td>
						<td style="width:20%;border-top:1px solid #ccc;margin-left:0;padding-top:0.1rem;padding-bottom:0.1rem;">${detail.originPrice}</td>
						<td style="width:20%;border-top:1px solid #ccc;margin-left:0;padding-top:0.1rem;padding-bottom:0.1rem;">${detail.discountPrice}</td>
						<td style="width:20%;border-top:1px solid #ccc;margin-left:0;padding-top:0.1rem;padding-bottom:0.1rem;">${detail.num}</td>
					</tr>
				</#list>
			</tbody>
		</table>
	</ul>
	<ul class="zichan">
		<table>
			<tr>
				<td>总价:</td>
				<td>${data.memberPrice}</td>
			</tr>
			<tr>
				<td>折后总价:<td>
				<td>${data.memberPrice}</td>			
			</tr>
		</table>
	</ul>
	
</body>
<script src="${basePath}/js/rem.js"></script>
</html>