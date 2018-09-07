<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0;"/>
<title>注册</title>
<link rel="stylesheet" type="text/css" href="${basePath}/css/login/style.css" />
<link rel="stylesheet" type="text/css" href="${basePath}/js/layer/mobile/need/layer.css" />
</head>

<body>
<div class="whole">
	<div class="title">注册</div>
    <div class="login-form">
    	<form id="regist-form">
        	<div class="user-name common-div">
            	<span class="eamil-icon common-icon">
                	<img src="${pageContext.request.contextPath}/images/eamil.png" />
                </span>
                <input type="email" name="phone" value="" placeholder="请输入手机号" required="required" />        
            </div>
            <div class="user-name common-div">
            	<span class="eamil-icon common-icon">
                	<img src="${pageContext.request.contextPath}/images/eamil.png" />
                </span>
                <input type="email" name="registCode" value="" placeholder="请输入注册码" required="required" />        
            </div>
            <div class="user-pasw common-div">
            	<span class="pasw-icon common-icon">
                	<img src="${pageContext.request.contextPath}/images/password.png" />
                </span>
                <input type="password" name="password" value="" placeholder="******" required="required"/>        
            </div>
            <div id="regist-btn" class="login-btn common-div">注册</div>
        </form>
    </div>
    <div class="forgets">
        <a href="/open/toLogin">登录</a>
    </div>
</div>
</body>
<script src="/js/jquery.min.js"></script>
<script src="/js/login/phone.js"></script>
<script src="/js/layer/mobile/layer.js"></script>
<script src="/js/jquery.hisform.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/login/login.js"></script>

<script>

</script>

</html>
