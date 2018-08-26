<!-- <div class="J-page-wrap pd20 mb45">
	<div class="base_page">
		<a type="button" class="btn btn-default j_page_prev_btn pull-left"><i class="fa fa-chevron-left"></i></a>
		<button href="" type="button" class="btn btn-default j_page_info base_page_info pull-left" disabled="disabled"></button>
		<a type="button" class="btn btn-default j_page_next_btn pull-left"><i class="fa fa-chevron-right"></i></a>
		
		<input class="form-control base_page_search_input pull-left" id="j_madule_page_search_input" type="text">
		<a class="btn btn-default j_madule_page_search_submit pull-left ml5" type="button">Go</a>
	</div>
</div>
 -->
<span id="ajaxPage"></span>
<input type="hidden" value="" id="ajaxUrl" />

<script type="text/javascript">
function goPageByAjax(pageNo){
	if(pageNo == ""){
		layer.msg("请填写页数");
	}
	settings.ajaxLoad(pageNo, $("#ajaxUrl").val());
}
</script>
