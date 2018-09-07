<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<div class="page-sidebar nav-collapse collapse">
	<div class="row" style="padding-left: 10px;display:none" id="hospitalList">
			<select id="switchHospital" style="margin-top: 7px;margin-left: 17px;width:200px;"></select>
			<button class="btn btn-primary btn-sm" onclick="switchHospital()" style="background: #00b0ea;border-color: #00b0ea;padding: 3.5px 11px;">确定</button>
	</div>
	<ul class="page-sidebar-menu">
		<li>
			<a class="sideblk blk" id="index" href="${ctx }/contentRoot/index.do">
				<i class="home"><img src="/images/back_home.png"/></i>
				<span class="title">首页</span>
				<span class="selected"></span>
			</a>
		</li>
			<li>
				<a class="sideblk blk" href="/backstage/banner/list">
					<i class="record"><img src="/images/back_banner.png"/></i>
					<span class="title">banner设置</span>
					<span class="arrowicon"></span>
				</a>
				<a class="sideblk blk" href="/backstage/category/list">
					<i class="record"><img src="/images/back_category.png"/></i>
					<span class="title">分类管理</span>
					<span class="arrowicon"></span>
				</a>
				<a class="sideblk blk" href="/backstage/product/list">
					<i class="record"><img src="/images/back_goods.png"/></i>
					<span class="title">商品管理</span>
					<span class="arrowicon"></span>
				</a>
				<a class="sideblk blk" href="/backstage/registCode/list">
					<i class="record"><img src="/images/back_category.png"/></i>
					<span class="title">注册码管理</span>
					<span class="arrowicon"></span>
				</a>
			</li>
		</ul>
	</div>
<input type="hidden" id="leftCss" value="${currentLabel}">
<script type="text/javascript" src="/js/back/leftside.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var leftCss = $("#leftCss").val();
	if(leftCss == 'index'){
	    $("#"+leftCss).attr("class","sideblk blk titactive");
	}else{
	    $("#"+leftCss).parent().attr("class","sub-menu subactive");
	    $("#"+leftCss).attr("class","titactive");
	}
	
});


</script>