<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<title>茶部落</title>
		 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<link href="/css/amazeui.min.css" type="text/css" rel="stylesheet" />
		<link href="/css/address.css" type="text/css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="/css/layer.css" />
	</head>
	<body>
		<header data-am-widget="header" class="am-header am-header-default sq-head ">
			<div class="am-header-left am-header-nav">
				<a href="javascript:history.back()" class="" style="border: 0;">
					<i class="am-icon-chevron-left"></i>
				</a>
			</div>
			<h1 class="am-header-title">
  	            <a href="" class="" style="color: #333;">管理收货地址</a>
            </h1>
            <div class="am-header-right am-header-nav">
				<a href="/order/toAddAddress/${oid}" class="">
					<i class="am-icon-plus" style="color: #999;"></i>
				</a>
			</div>
	    </header>
	    <div style="height: 49px;"></div>
	    <ul class="address-list">
	    	<#list data as data>
	    		<li class="curr">
		    		<p>收货人：${data.name}&nbsp;&nbsp;${data.mobile}<a style="float: right;color: #bbb;" href="/order/confirm/${oid}/${data.id}" data="${data.id}">选择</a></p>
		    		<p class="order-add1">收货地址：${data.province} ${data.city} ${data.area} ${data.exactly}</p>
		    	    <hr />
		    	    <div class="address-cz">
		    	    	<label class="am-radio am-warning" data="${data.id}">
		    	    		<#if data.isDefault == 0>
		    	    			<input type="radio" name="radio3" value="" data-am-ucheck> 设为默认
		    	    		</#if>
		    	    		<#if data.isDefault == 1>
		    	    			<input type="radio" name="radio3" value="" data-am-ucheck checked> 设为默认
		    	    		</#if>
	                    </label>
	                    <a href="/order/toModifyAddress/${oid}/${data.id}" class="modify"><img src="/images/bj.png" width="18" />&nbsp;编辑</a>
	                    <a href="javascript:void(0)" class="delete" data="${data.id}">删除</a>
		    	    </div>
		    	</li>
	    	</#list>
	    </ul>
	</body>
	<script src="/js/jquery.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="/js/commonLib.js"></script>
	<script type="text/javascript" src="/js/layer/layer.js"></script>
	<script>
		$(document).ready(function(){
			$(".am-radio.am-warning").on("click", function(){
				var url = "/order/updDefault"
				$.getMyContentJSON(url,JSON.stringify({"id":$(this).attr("data")}),function(data){
					if(data.returncode == 0){
						layer.msg("已修改默认地址");
						setTimeout("window.location.reload()", 1500)
					}
				});
			});
			$(".delete").on("click", function(){
				if($(this).parents(".curr").find("input[name=radio3]").attr("checked") == 'checked'){
					layer.msg("不可删除默认地址,请先设置其他默认地址");
					return;
				}
				var url = "/order/delAddress"
				$.getMyContentJSON(url,JSON.stringify({"id":$(this).attr("data")}),function(data){
					if(data.returncode == 0){
						layer.msg("已删除");
						$(this).parents(".curr").remove();
						setTimeout("window.location.reload()", 1500)
					}
				});
			});
		});
	</script>
</html>
