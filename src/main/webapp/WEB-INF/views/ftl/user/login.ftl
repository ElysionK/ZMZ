<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0;"/>
<title>登录</title>
<link rel="stylesheet" type="text/css" href="${basePath}/css/login/style.css" />
<link rel="stylesheet" type="text/css" href="${basePath}/js/mobile/need/layer.css" />

</head>

<body>
<div class="whole">
	<div class="title">登录</div>
    <div class="login-form">
    	<form id="login-form">
        	<div class="user-name common-div">
            	<span class="eamil-icon common-icon">
                	<img src="${pageContext.request.contextPath}/images/eamil.png" />
                </span>
                <input type="email" name="phone" value="" placeholder="请输入手机号" required="required" />        
            </div>
            <div class="user-pasw common-div">
            	<span class="pasw-icon common-icon">
                	<img src="${pageContext.request.contextPath}/images/password.png" />
                </span>
                <input type="password" name="password" value="" placeholder="******" required="required" />        
            </div>
            <div id="login-btn" class="login-btn common-div">登录</div>
        </form>
    </div>
    <div class="forgets">
        <a href="/open/toRegist">注册</a>
    </div>
</div>
</body>
<script src="${basePath}/js/jquery.min.js"></script>
<script src="${basePath}/js/login/phone.js"></script>
<script src="${basePath}/js/layer/mobile/layer.js"></script>
<script src="${basePath}/js/jquery.hisform.js" type="text/javascript" charset="utf-8"></script>
<script src="${basePath}/js/login/login.js"></script>



</html>
