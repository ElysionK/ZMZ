<script src="${basePath}/js/pagination.js" type="text/javascript"></script>

<div class="J-page-wrap pd20 mb45">
	<div class="base_page">
		<a type="button" class="btn btn-default j_page_prev_btn pull-left"><i class="fa fa-chevron-left"></i></a>
		<button href="" type="button" class="btn btn-default j_page_info base_page_info pull-left" disabled="disabled"></button>
		<a type="button" class="btn btn-default j_page_next_btn pull-left"><i class="fa fa-chevron-right"></i></a>
		
		<input class="form-control base_page_search_input pull-left" id="j_madule_page_search_input" type="text">
		<a class="btn btn-default j_madule_page_search_submit pull-left ml5" type="button">Go</a>
	</div>
</div>


<script type="text/javascript">
(function ($) {
var params = {
			  "pageNum":${RequestParameters.page?default("1")},
			  "totalPages":${pager.totalPages},
			  "totalCount":${pager.totalRows}
			 };
pagination.init(params);
})(jQuery);
</script>
