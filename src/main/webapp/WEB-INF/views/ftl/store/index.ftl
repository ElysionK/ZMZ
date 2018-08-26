<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>店铺名称</title>
	<link rel="stylesheet" href="${basePath}/css/public.css">
	<link rel="stylesheet" href="${basePath}/css/index.css">
	<link rel="stylesheet" href="${basePath}/css/swiper.css">
</head>
<body>
	<header>
		<div class="header_top">
		</div>
		<input type="text" placeholder="炸鸡">
		<em class="search">&#xe78d;</em>
	</header>
	<main class="banner">
		<div class="swiper-container" >
			<div class="swiper-wrapper">
				<div class="swiper-slide"><img class="swiper-lazy" src="../../../../images/Screenshot_2018-04-17-15-11-33-84_02.png"/></div>
				<div class="swiper-slide"><img src="../../../../images/Screenshot_2018-04-17-15-11-33-84_02.png" /></div>
				<div class="swiper-slide"><img src="../../../../images/Screenshot_2018-04-17-15-11-33-84_02.png"/></div>
				<!-- <div class="swiper-slide"><a href="http://p.51towin.com/core/tooth.toothProductList.do"><img src="/img/yiyuangou.jpg" style="width:100%;height:165px;"/></a></div>
				
				<div class="swiper-slide"><a href="http://p.51towin.com/core/product.toProductDetail.do?cgVariable.pid=1748&isCard=1"><img class="swiper-lazy" src="img/499.jpg" style="width:100%;" height="165"/></a></div>
				<div class="swiper-slide"><a href="http://p.51towin.com/core/product.toProductDetail.do?cgVariable.pid=2265&isCard=1"><img class="swiper-lazy" src="img/lekangka.jpg" style="width:100%;" height="165"/></a></div>
				<div class="swiper-slide"><a href="http://p.51towin.com/core/product.toProductDetail.do?cgVariable.pid=2267&isCard=1"><img class="swiper-lazy" src="img/yuekangka.jpg" style="width:100%;" height="165"/></a></div> -->
			</div>
			<div class="swiper-pagination"></div>
		</div>
		<!-- <img src="../../../../images/Screenshot_2018-04-17-15-11-33-84_02.png" alt=""> -->
	</main>
	<ul class="list">
		<li>
			<img src="../../../../images/Screenshot_2018-04-10-09-16-05-19_03.png" alt="">
			<span class="list_word">美食</span>
		</li>
		<li>
			<img src="../../../../images/Screenshot_2018-04-17-15-11-33-84_05.png" alt="">
			<span class="list_word">美团超市</span>
		</li>
		<li>
			<img src="../../../../images/Screenshot_2018-04-17-15-11-33-84_07.png" alt="">
			<span class="list_word">生鲜果蔬</span>
		</li>
		<li>
			<img src="../../../../images/Screenshot_2018-04-17-15-11-33-84_09.png" alt="">
			<span class="list_word">美团专送</span>
		</li>
		<li>
			<img src="../../../../images/Screenshot_2018-04-17-15-11-33-84_11.png" alt="">
			<span class="list_word">跑腿代购</span>
		</li>
		<li>
			<img src="../../../../images/Screenshot_2018-04-17-15-11-33-84_18.png" alt="">
			<span class="list_word">下午茶</span>
		</li>
		<li>
			<img src="../../../../images/Screenshot_2018-04-17-15-11-33-84_20.png" alt="">
			<span class="list_word">汉堡披萨</span>
		</li>
		<li>
			<img src="../../../../images/Screenshot_2018-04-17-15-11-33-84_21.png" alt="">
			<span class="list_word">快食简餐</span>
		</li>
		<li>
			<img src="../../../../images/Screenshot_2018-04-17-15-11-33-84_22.png" alt="">
			<span class="list_word">家常菜</span>
		</li>
		<a href="list.html">
			<li>
				<img src="../../../../images/Screenshot_2018-04-17-22-25-07-38_03.png" alt="">
				<span class="list_word">全部分类</span>
			</li>
		</a>
	</ul>
	<section class="youxuan">
		<h1 class="youxuan_title">为你优选</h1>
		<em class="right right1">&#xe639;</em>
		<h2>更多</h2>
		<ul class="youxuan_box">
			<li>
				<img src="../../../../images/Screenshot_2018-04-17-15-11-43-19_03 (2).png" alt="">
				<p>附近热卖商家</p>
			</li>
			<li>
				<img src="../../../../images/Screenshot_2018-04-17-15-11-43-19_05.png" alt="">
				<p>明星林心如曾光顾</p>
			</li>
			<li>
				<img src="../../../../images/Screenshot_2018-04-17-15-11-43-19_03 (2).png" alt="">
				<p>附近热卖商家</p>
			</li>
			<li>
				<img src="../../../../images/Screenshot_2018-04-17-15-11-43-19_05.png" alt="">
				<p>明星林心如曾光顾</p>
			</li>
			<li>
				<img src="../../../../images/Screenshot_2018-04-17-15-11-43-19_03 (2).png" alt="">
				<p>附近热卖商家</p>
			</li>
			<li>
				<img src="../../../../images/Screenshot_2018-04-17-15-11-43-19_05.png" alt="">
				<p>明星林心如曾光顾</p>
			</li>
		</ul>
	</section>
	<#include "/public/menu.ftl" />
	<a href="shopcar.html"><div class="shop">&#xe6af;</div></a>
</body>
<script src="${basePath}/js/rem.js"></script>
<script src="${basePath}/js/swiper.js"></script>
<script>
var swiper = new Swiper('.swiper-container', {
 	direction: 'horizontal',
    loop: true,
    speed : 800,
    autoplay : 2000,
    pagination: '.swiper-pagination',
    nextButton: '.swiper-button-next',
    prevButton: '.swiper-button-prev',
    preventLinksPropagation : false,
    autoplayDisableOnInteraction: false
});
</script>
</html>