<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>elem联动菜单</title>
    <meta name="viewport" content="width=device-width, user-scalable=no" />
    <link href="/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen" href="/css/order.css" />
    <link rel="stylesheet" type="text/css" href="/css/layer.css" />
</head>
<body>
    <div id="app">
        <header>
            我是一个仿饿了么动画
        </header>
        <div class="notice"></div>
        <div class="goods">
            <div class="left" ref="left">
                <ul class="right-click" id="order-category">
					
				</ul>
            </div>
            <div class="right" id="order-product">
            	
            </div>
        </div>

        <!-- 运动的小球 -->
        <div id="points">
            <div class="pointOuter pointPre">
                <div class="point-inner"></div>
            </div>  
            <div class="pointOuter pointPre">
                <div class="point-inner"></div>
            </div>  
            <div class="pointOuter pointPre">
                <div class="point-inner"></div>
            </div>  
            <div class="pointOuter pointPre">
                <div class="point-inner"></div>
            </div>  
            <div class="pointOuter pointPre">
                <div class="point-inner"></div>
            </div>  
            <div class="pointOuter pointPre">
                <div class="point-inner"></div>
            </div>  
            <div class="pointOuter pointPre">
                <div class="point-inner"></div>
            </div>  
        </div>
        
        <div class="footer">
            <div>
                <i class="fa fa-shopping-cart"></i>
                <!--记录订单总数  -->
                <div class="total">0</div>
            </div>
            <div class="pay notPay">去结算</div>
        </div>
    </div>
<script id="categories" type="text/x-jsrender">
	{{for}}
		{{if #getIndex() == 0}}
			<li class="click" index="{{:#getIndex()}}" data="{{:id}}">{{:name}}</li>
		{{else}}
			<li class="" index="{{:#getIndex()}}" data="{{:id}}">{{:name}}</li>
		{{/if}}
	{{/for}}
</script>
<script id="products" type="text/x-jsrender">
	{{for}}
		<li id="{{:title}}">
			<h1 class="goodTitle">{{:title}}</h1>
			<ul class="good">
				{{for product}}
					<li>
						<div>
							<img height="57" src="${pageContext.request.contextPath}/upload/{{:img}}">
							<span>{{:name}}</span>
						</div>
						<div class="counter">
							<div class="pop">
								<i class="fa fa-minus-circle" data="{{:id}}"></i> <e>0</e>
							</div>
							<i class="fa fa-plus-circle" data="{{:id}}"></i>
						</div>
					</li>
				{{/for}}
			</ul>
		</li>
	{{/for}}
</script>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/commonLib.js"></script>
<script type="text/javascript" src="/js/jsrender.js"></script>
<script type="text/javascript" src="/js/order.js"></script>
<script type="text/javascript" src="/js/layer/layer.js"></script>
<script>
(function ($) {
	setting.init();
})();
</script>
</body>
</html>