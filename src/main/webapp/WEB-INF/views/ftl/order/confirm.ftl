<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>elem联动菜单</title>
    <meta name="viewport" content="width=device-width, user-scalable=no" />
    <link href="/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen" href="/css/order_confirm.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="/css/layer.css" />
</head>
<body>
    <ul class="list-detail">
    	<li class="time">
    		<span>配送信息：</span><input id="endTime" class="kbtn" placeholder="${data.address.name} ${data.address.mobile}">
    		<i class="am-icon-angle-right"></i>
    	</li>
    	<li class="time">
    		<span>配送地址：</span><input id="endTime" class="kbtn" placeholder="${data.address.provinceName} ${data.address.cityName} ${data.address.areaName} ${data.address.exactly}">
    		<i class="am-icon-angle-right"></i>
    	</li>
    	<input type="hidden" id="aid" value="${data.address.id}" />
    	<div id="datePlugin"></div>
    </ul>
    
    <div class="goods">
		<div class="foods-wrapper">
			<ul>
				<#list data.order as info>
					<li class="food-item border-1px">
						<div class="icon">
							<img height="57" src="http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/114/h/114">
						</div>
						<div class="content">
							<h2 class="name">${info.name}</h2>
							<div class="extra">
								<span class="count">原价#{info.proNormalPrice ;m1M2}</span><span>劲省#{info.proNormalPrice - info.proMemberPrice ;m1M2}</span>
							</div>
							<div class="price">
								<span class="now">￥#{info.proMemberPrice ;m1M2}</span><span class="old" style="display: none;">￥</span>
							</div>
						</div>
					</li>
				</#list>
			</ul>
		</div>
	</div>
    
    <div class="footer">
		<div class="pay" id="check">确认</div>
			<#list data.order as c>
			     <#if c_index == 0>
			      	<input type="hidden" id="oid" value="${c.oid}" />
			     </#if>
			</#list>
     </div>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/commonLib.js"></script>
<script type="text/javascript" src="/js/layer/layer.js"></script>
<script>
$(document).ready(function(){
	$("#check").on("click", function(){
		$.getMyJSON("/order/confirmOrder", {"aid" : $("#aid").val(), "oid" : $("#oid").val()}, function(data){
			if(data.returncode == 0){
				layer.alert('提交成功！', {icon: 6});
	   	   		setTimeout(function(){
	    			window.location.href="/"
	    		},1000);
			}
		});
	});
});
</script>
</body>
</html>