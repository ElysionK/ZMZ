<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>banner 列表</title>
	<%@include file="../public/head.jsp" %>
	<link href="/css/back/category.css" rel="stylesheet" type="text/css" />
	<link href="/css/back/addCategory.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="page-container">
	<%@include file="../public/leftMenu.jsp" %>
	<div class="page-content">
		<div class="contenttop">
			<div class="tit">banner 列表</div>
		</div>
		
		<div class="portlet-body">
			<table class="table table-striped table-hover table-bordered" id="sample_editable_1">
				<thead>
					<tr>
						<th><input type="checkbox" class="checkAll" disabled/></th>
						<th>序号</th>
                       	<th>简述</th>
                        <th>图片</th>
                        <th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="list">
						<tr>
							<td><input type="checkbox" class="pids" value=""  data=""/></td>
							<td id="${list.id}" class="sort-no">${list.sort}</td>
							<td class="banner-brief">${list.brief}</td>
							<td><img alt="" src="${pageContext.request.contextPath}/upload/${list.img}"></td>
							<td>
								<a class="cek detail upd-btn">修改</a>
								<a class="cek detail sort-btn">排序</a>
							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="new-add">
				<span class="add-btn" onclick="window.location.href='/backstage/banner/add'">新增</span>
			</div>
		</div>
	</div>
	
	<!-- sort modal -->
	<div class="modal fade" id="sortModal" style="display:none" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel"></h4>
	      </div>
	      <div class="modal-body">
	        <table class="table table-bordered table-hover m10" style="width:90%;">
	        	<input type="hidden" id="banner-1-id">
	        	<input type="hidden" id="banner-1-no">
                 <tbody>
                     <tr>
                         <td width="15%">当前序号</td>
                         <td>
                             <select id="sort-select"></select>
                         </td>
                     </tr>
                  </tbody>
             </table>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="save-sort-btn">保存</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- update modal -->
	<div class="modal fade" style="width:50%;display:none" id="updModal" tabindex="-1" role="dialog" aria-labelledby="updModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="updModalLabel">修改</h4>
	      </div>
	      <div class="modal-body">
	        <form class="" id="updBanner" enctype="multipart/form-data">
                    <table class="table-hover m10" style="width:90%;">
                        <tbody>
                        	<input type="hidden" name="id" id="upd-banner-id">
                            <tr>
                                <td width="15%" class="tableleft"><span style="color:red">*</span>简述</td>
                                <td>
                                    <input type="text" id="upd-banner-brief" name="brief" datatype="*" nullmsg="请输入简述" maxlength="50">
                                     <span class="Validform_checktip"></span>
                                </td>
                            </tr>
                            <tr>
                                <td class="tableleft"><span style="color:red">*</span>banner 配图</td>
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
                        </tbody>
                    </table>
                </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="upd-banner-btn">保存</button>
	      </div>
	    </div>
	  </div>
	</div>
	<%@include file="../public/footer.jsp" %>
</div>
</body>
<script src="/js/function.js" type="text/javascript"></script>
<script src="/js/jquery.hisform.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
$(function(){


});

$(document).on('click', '.upd-btn', function() {
	modifyBanner(this);
});

function modifyBanner(that) {
	var parentTr = $(that).parents('tr');
	$('#previewImg0').attr('src', parentTr.find('img').attr('src'));
	$('#upd-banner-brief').val(parentTr.find('.banner-brief').text());
	$('#upd-banner-id').val(parentTr.find('.sort-no').attr('id'));
	showModal('updModal');
}

$(document).on('click', '#upd-banner-btn', function() {
	$("#updBanner").ajaxSubmit({
	    url: "/backstage/banner/update",
	    type: "post",
		dataType: "json",
	    success:function (data) {
	   	   if(data.returncode==0){
	   	   		layer.alert('修改成功！', {icon: 6});
	   	   		$('#updModal').modal('hide');
	   	   		setTimeout(function(){
	   	   			window.location.reload();
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

$(document).on('click', '.sort-btn', function() {
	modifySort(this);
});

function modifySort(that) {
	var parentTr = $(that).parents('tr');
	$('#myModalLabel').text('设置序号');
	$('option').remove();
	var currentBannerId = parentTr.find('.sort-no').attr('id');
	$('#banner-1-id').val(currentBannerId);
	$('#banner-1-no').val($('#' + currentBannerId).text());
	$('.sort-no').each(function() {
		var id = $(this).attr('id');
		if (id == currentBannerId) {
			$('#sort-select').append("<option value='" + id + "' selected='selected'>" + $(this).text() + "</option>");
		} else {
			$('#sort-select').append("<option value='" + id + "'>" + $(this).text() + "</option>");
		}
	});
	showModal('sortModal');
}

$(document).on('click', '#save-sort-btn', function() {
	var selectOption = $('#sort-select option:selected');
	if ($('#banner-1-id').val() ==  selectOption.val()) {
		return;
	}
	var dataJSON = JSON.stringify([
		{
			"id": $('#banner-1-id').val(),
			"sort": selectOption.text()
		},
		{
			"id": selectOption.val(),
			"sort": $('#banner-1-no').val()
		}
	]); 
	$.ajax({
        type : "POST",
        url : "/backstage/banner/sort/update",
        data : dataJSON,
        dataType : "json",
        contentType : "application/json; charset=utf-8",
        success:function (data) {
 	   	   if(data.returncode==0){
 	   	   		layer.alert('修改成功！', {icon: 6});
 	   	   		$('#sortModal').modal('hide');
 	   	   		setTimeout(function(){
 	   	   			window.location.reload();
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

function showModal(modalId) {
	//获取modal的宽度
	var modalWidth = $("#" + modalId).width();
	//计算偏移量
	var left = "-" + parseInt(modalWidth) / 2 + "px";
	//modal居中
	$('#' + modalId).modal('show').css({"margin-left":left});
}

</script>
</html>