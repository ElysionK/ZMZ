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
			<h3 style="color: white;">XXX商铺</h3>
		</div>
	</header>
	<main class="banner">
		<div class="swiper-container" >
			<div class="swiper-wrapper">
				<#list data.banners as banner>
					<div class="swiper-slide">
						<img class="swiper-lazy" src="${pageContext.request.contextPath}/upload/${banner.img}" alt="">
					</div>
				</#list>
			</div>
			<div class="swiper-pagination"></div>
		</div>
		<!-- <img src="../../../../images/Screenshot_2018-04-17-15-11-33-84_02.png" alt=""> -->
	</main>
	<ul class="list">
		<#list data.categories as category>
			<li onclick="window.location.href='/order/index'">
				<img src="${pageContext.request.contextPath}/upload/${category.img}" alt="">
				<span class="list_word">${category.name}</span>
			</li>
		</#list>
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
    autoplayDisableOnInteraction: true
});
</script>
</html>