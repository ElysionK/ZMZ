<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <title>首页</title>
<%@include file="./public/head.jsp" %>
<link href="/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<input type="hidden" id="leftCss" value="index">
<div class="page-container">
	<%@include file="./public/leftMenu.jsp" %>
    <div class="contentBox" style="margin-top: 15px;">
        <div class="menulink">
      	<h4>  欢迎您进入天问医疗管理平台-医生端，请点击左侧菜单进行操作</h4>
        </div>
    </div>
	<%@include file="./public/footer.jsp" %>
</div>
</body>
</html>