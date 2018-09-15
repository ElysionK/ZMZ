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
		<link rel="stylesheet" href="/css/ydui.css?rev=@@hash">
		<link rel="stylesheet" href="/css/demo.css">
		<link rel="stylesheet" type="text/css" href="/css/layer.css" />
	</head>
	<body>
		<header data-am-widget="header" class="am-header am-header-default sq-head ">
			<div class="am-header-left am-header-nav">
				<a href="javascript:history.back()" class="" style="border: 0;">
					<i class="am-icon-chevron-left"></i>
				</a>
			</div>
			<h1 class="am-header-title" >
  	            <a href="" class="" style="color: #333;">修改收货地址</a>
            </h1>
	    </header>
	    <div style="height: 49px;"></div>
	    <ul class="contact">
	    	<li><input id="J_Address" type="text" value="${data.province} ${data.city} ${data.area}" readonly placeholder="请选择省市区"/></li>
	    	<li><input id="excatly" type="text" value="${data.exactly}" placeholder="请输入详细地址"/></li>
	    	<li><input id="name" type="text" value="${data.name}" placeholder="请输入姓名"/></li>
	    	<li><input id="mobile" type="text" value="${data.mobile}" placeholder="请输入手机号"/></li>
	    </ul>
	    <input id="oid" type="hidden" value="${oid}"/>
	    <input id="id" type="hidden" value="${data.id}"/>
	    <input id="province" type="hidden" value="${data.province}"/>
	    <input id="city" type="hidden" value="${data.city}"/>
	    <input id="area" type="hidden" value="${data.area}"/>
	    <button class="paybtn" type="button" id="save"> 确定</button>
	</body>
	<script src="/js/jquery.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="/js/commonLib.js"></script>
	<script src="/js/amazeui.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="/js/ydui.flexible.js"></script>
	<script type="text/javascript" src="/js/ydui.citys.js"></script>
	<script type="text/javascript" src="/js/ydui.js"></script>
	<script type="text/javascript" src="/js/layer/layer.js"></script>
	<script>
	!function () {
		var $target = $('#J_Address');

		$target.citySelect({
			provance: $("#province").val(),
			city: $("#city").val(),
			area: $("#area").val()
		});

		$target.on('click', function (event) {
			event.stopPropagation();
			$target.citySelect('open');
		});

		$target.on('done.ydui.cityselect', function (ret) {
			$(this).val(ret.provance + ' ' + ret.city + ' ' + ret.area);
		});
		
		$("#save").on("click", function(){
			if($("#J_Address").val() == undefined || $("#J_Address").val() == ''){
				layer.msg("请选择省市区");
				return;
			}
			if($("#excatly").val() == undefined || $("#excatly").val() == ''){
				layer.msg("请填写详细地址");
				return;
			}
			if($("#name").val() == undefined || $("#name").val() == ''){
				layer.msg("请填写姓名");
				return;
			}
			if($("#mobile").val() == undefined || $("#mobile").val() == ''){
				layer.msg("请填写手机号码");
				return;
			}
			var add = $("#J_Address").val().split(" ");
			var url = "/order/updAddress"
			var data = {"id":$("#id").val(),"province":add[0],"city":add[1],"area":add[2],"exactly":$("#excatly").val(),"name":$("#name").val(),"mobile":$("#mobile").val()}
			$.getMyContentJSON(url,JSON.stringify(data),function(data){
				if(data.returncode == 0){
					layer.msg("修改成功");
					setTimeout("window.location.href='/order/toAddress/"+$("#oid").val()+"'", 1500)
				}
			});
		});
	}();
	</script>
</html>
