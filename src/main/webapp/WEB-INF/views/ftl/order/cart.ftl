<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>购物车</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/css/style.css" />
		<link rel="stylesheet" type="text/css" href="/css/layer.css" />
	</head>

	<body>
		<div style="height: 0.8344rem;">
			<div class="m-hd">
				<div class="m-cartHd">
					<span class="logo">购物车</span>
					<div class="right">
						编辑
					</div>
				</div>
			</div>
		</div>
		<div class="m-mainView">
			<ul class="cartGroupList">
				<li class="item">
					<div class="m-cartGroup">
						<ul class="list">
							<#list data as data>
								<li class="item pro" data="${data.pid}" data-c="${data.cid}">
									<div class="m-swipeOut">
										<div class="inner">
											<div class="cnt">
												<div class="m-cartGood">
													<div>
														<#if data.checked == 0>
															<i class="m-checkbox checkbox check"></i>
														</#if>
														<#if data.checked == 1>
															<i class="m-checkbox checkbox checked"></i>
														</#if>
														<div class="m-good">
															<div class="imgWrap">
																<img src="${pageContext.request.contextPath}/upload/${data.img}" />
															</div>
															<div class="cnt">
																<p class="line1">
																	<span>${data.name}</span>
																</p>
																<p class="line2">￥${data.orignalPrice}</p>
																<div class="line3">
																	<span class="price">
																		<span>¥</span>
																	<span class="dis-price">${data.discountPrice}</span>
																	</span>
	
																	<div class="m-selnum">
																		<i class="less">－</i>
																		<div class="textWrap">
																			<input type="tel" value="${data.quantity}">
																		</div>
																		<i class="more">+</i>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</li>
							</#list>
						</ul>
					</div>
				</li>
			</ul>
		</div>
		<div class="m-billingFt m-cartFt">
			<div class="left">
				<div class="checkAll f-vc">
					<p class="price u-text-red s">
						<span>合计：</span>￥<em id="total">88.00</em>
					</p>
				</div>
			</div>

			<div class="btn w-button" id="confirm">下单</div>
		</div>
	</body>
	<script type="text/javascript" src="/js/jquery.min.js"></script>
	<script type="text/javascript" src="/js/commonLib.js"></script>
	<script src="/js/cart_rem.js" type="text/javascript" charset="utf-8"></script>
	<script src="/js/cart.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="/js/layer/layer.js"></script>
	<script>
	(function ($) {
		setting.init();
	})();
	</script>
</html>