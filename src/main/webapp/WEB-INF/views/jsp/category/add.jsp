<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>新增分类</title>
    <%@include file="../public/head.jsp" %>
    <link href="/css/back/addCategory.css" rel="stylesheet" type="text/css"/>
    <link href="/css/flavr/flavr.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="/plugin/layer/css/layui.css" />
</head>
<body>
<div class="page-container">
	<%@include file="../public/leftMenu.jsp" %>
    <div class="page-content">
        <div class="hds">新增分类</div><br>
                <div class="portlet-body">
                    <form class="definewidth m20" id="addCategory" enctype="multipart/form-data">
                        <table class="table table-bordered table-hover m10" style="width:90%;">
                            <tbody>
                                <tr>
                                    <td width="15%" class="tableleft"><span style="color:red">*</span>名称</td>
                                    <td>
                                        <input type="text" name="name" datatype="*" nullmsg="请输入分类名称" maxlength="50">
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
                                    <td width="15%" class="tableleft"><span style="color:red">*</span>排序</td>
                                    <td>
                                        <input type="text" name="sort" datatype="*" nullmsg="请输入排序" maxlength="50">
                                         <span class="Validform_checktip"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableleft"></td>
                                    <td>
                                    	<input type="button" id="saveCategory" class="save" value="保存">
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
<script src="/plugin/layer/layer.js" type="text/javascript" charset="utf-8"></script>
<script>
$(document).ready(function(){
	$("#saveCategory").on("click", function(){
    	$("#addCategory").ajaxSubmit({
    	    url: "/backstage/category/addNew",
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
});
	
</script>
</body>
</html>