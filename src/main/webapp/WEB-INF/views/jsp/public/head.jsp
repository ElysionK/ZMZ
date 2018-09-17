<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<%@ include file="./tags.jsp" %>
<link href="/css/back/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="/css/back/style.css" rel="stylesheet"><!--公共导航部分--->
<link rel="stylesheet" type="text/css" href="/css/layer.css" />
<div class="top">
    <div class="left"><img src="/images/back_index.png" alt="logo" style="width: 35px;"/>商家后台<span class="wel">欢迎登录！</span></div>
    <div class="right" style="float: none"> 
    <a onclick="logout()" style="color: #fff;"><img alt="退出登录" src="/images/loginOut.png" /><span class="username">退出登录</span></a>
    </div>
</div>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/back/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/commonLib.js"></script>
<script type="text/javascript" src="/js/flavr/flavr.js"></script>
<script type="text/javascript" src="/js/globalMsg.js"></script>
<script type="text/javascript" src="/js/layer/layer.js"></script>
<script>
	function logout() {
		$.ajax({
	        type : "POST",
	        url : "/backstage/logout",
	        success:function (data) {
	 	   	   if (data.returncode == 0) {
	 	   		   window.location.reload();
	 	   	   } else {
	 	   		   alert('退出登录失败');
	 	   	   }
	 	    },
	 	    error: function (error) { 
	 	    	alert('网络连接失败'); 
	 	    }
	    });
	}
</script>
