<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>新增套餐</title>
    <%@include file="../public/head.jsp" %>
    <link href="/css/back/addCategory.css" rel="stylesheet" type="text/css"/>
    <link href="/css/flavr/flavr.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page-container">
	<%@include file="../public/leftMenu.jsp" %>
    <div class="page-content">
        <div class="hds">新增套餐</div><br>
                <div class="portlet-body">
                    <form class="definewidth m20" id="addProduct" enctype="multipart/form-data">
                        <table class="table table-bordered table-hover m10" style="width:90%;">
                            <tbody>
                                <tr>
                                    <td width="15%" class="tableleft"><span style="color:red">*</span>名称</td>
                                    <td>
                                        <input type="text" name="name" datatype="*" nullmsg="请输入套餐名称" maxlength="50">
                                         <span class="Validform_checktip"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="15%" class="tableleft"><span style="color:red">*</span>套餐类别</td>
                                    <td>
                                        <select name="category" datatype="*" nullmsg="请选择套餐类别">
                                        	<c:forEach items="${list}" var="list" varStatus="sort">
                                        		<option value="${list.id}">${list.name}</option>
                                        	</c:forEach>
                                        </select>
                                         <span class="Validform_checktip"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableleft"><span style="color:red">*</span>套餐配图</td>
                                    <td>
										 <div class="scmdxxt">
		                                    <span class="sfz">
		                                    	<a onclick="$('#fileName0').click();" href="javascript:void(0);"><img id="previewImg0"/></a>
		                        				<input id="fileName0" type="file" name="mainFile" class="scwjanys preview" size="28" url-data="0"/>
		                                    </span>
		                                </div>
		                                <input type="hidden" accept="image/jpg,image/png,image/gif,image/bmp,image/jpeg,image/JPG,image/PNG,image/GIF,image/BMP,image/JPEG" id="imgUrl0" name="img" datatype="*" nullmsg="请上传套餐配图！"/>
                                    	 <span class="Validform_checktip" ></span>  
                                    </td>
                                </tr>
                                <tr>
                                    <td width="15%" class="tableleft"><span style="color:red">*</span>原价</td>
                                    <td>
                                        <input type="number" name="orignalPrice" datatype="*" nullmsg="请输入价格" maxlength="50">
                                         <span class="Validform_checktip"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="15%" class="tableleft"><span style="color:red">*</span>折扣</td>
                                    <td>
                                        <input type="number" name="discountPrice" datatype="*" nullmsg="请输入折扣" maxlength="50">
                                         <span class="Validform_checktip"></span>
                                    </td>
                                </tr>
                                 <tr>
                                    <td width="15%" class="tableleft"><span style="color:red">*</span>简述</td>
                                    <td>
                                        <input type="text" name="brief" datatype="*" nullmsg="请输入简述" maxlength="50">
                                         <span class="Validform_checktip"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableleft"></td>
                                    <td>
                                    	<input type="button" id="saveProduct" class="save" value="保存">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
    </div>
    <%@include file="../public/footer.jsp" %>
    </div>
<script type="text/javascript" src="/js/pagination.js"></script>
<script src="/js/function.js" type="text/javascript"></script>
<script src="/js/jquery.hisform.js" type="text/javascript" charset="utf-8"></script>
<script>
$(document).ready(function(){
	$("#saveProduct").on("click", function(){
    	$("#addProduct").ajaxSubmit({
    	    url: "/backstage/product/addNew",
    	    type: "post",
    		dataType: "json",
    	    success:function (data) {
    	   	   if(data.returncode==0){
    	   	   		layer.alert('新增成功！', {icon: 6});
    	   	   		setTimeout(function(){
    	    			window.history.back(-1);
    	    		},1000);
    	   	   }else{                   	   
    	   	   		layer.msg(data.errmsg);
    	   	   }              
    	    },
    	    error: function (error) { 
    	    	layer.msg('网络连接失败', {icon: 1}); 
    	    }
    	});
    });
	/*
	$('#addCategory').sgfmform({
		btnSubmit:"#saveCategory",
		ajaxurl : '/backstage/category/addNew',
		tiptype : 2,
		submittype: 2,
		postonce : true,
		callback : function(data, url){
			if (data.returncode == 0){
				alertMsg({"type" : 1, "content" : data.errmsg, "close" : true, "timeout" : 1500});
				setTimeout("window.location.href='${ctx}/core/checkupProduct.toProductList.do'",1800);
			} else {
				alertMsg({"type":2, "content" : data.errmsg, "close" : true, "timeout" : 2000});
			}
		}
	})*/
});
	
</script>
</body>
</html>