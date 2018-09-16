package com.tianwen.base.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tianwen.common.util.JsonResponseResult;

/**
 * @author LiuPing 分页数据封装类，该类携带分页参数和当前页数据。在分页查询中通过传入和返回该类达到统一 分页操作的目的。
 */
public class Pager extends JsonResponseResult {

	private static int PAGE_SIZE = 20;
	private int totalRows; // 总行数
	private int startRow;
	private int pageSize = Pager.PAGE_SIZE; // 每页显示的行数
	private int currentPage; // 当前页号
	private int totalPages; // 总页数
	@SuppressWarnings("unchecked")
	private List list; // 存放查询出的数据结果
	// 对外使用
	private int pageNo;
	private String pageScale;

	public Pager() {
	}
	
	public static Builder build(Map<String, Object> param){
		return new Builder(param);
	}
	
	public static class Builder{
		
		private Map<String, Object> src;

		private Pager pager;
		
		private int pageNo;
		
		private int totalRows; // 总行数

		public static Builder with(Map<String, Object> param){
			return  new Builder(param);
		}
		
		private Builder(Map<String, Object> param) {
			if (param == null) {
				throw new IllegalArgumentException(" param must not be null");
			}
			this.src = param;
			Object pageNo = param.get("pageNo");
			if (pageNo == null) {
				this.pageNo = 0;
			} else if (pageNo instanceof Integer) {
				this.pageNo = ((Integer) pageNo).intValue(); 
			} else if (pageNo instanceof String) {
				this.pageNo = Integer.parseInt((String) pageNo);
			} else {
				throw new IllegalArgumentException(" pageNo must be Integer or String ");
			}
		}
		
		public Builder setPageNo(int pageNo) {
			this.pageNo = pageNo;
			return this;
		}

		public Builder setTotalRows(int totalRows) {
			this.totalRows = totalRows;
			return this;
		}

		public Pager build(){
			this.pager = new Pager();
			this.pager.pageSize = 10;
			this.pager.setPageNo(String.valueOf(pageNo));
			return this.pager;
		}
	}
	
	public Pager(final String pageNo) {
		setPageNo(pageNo);
	}

	public Pager(final String pageNo, final String pageScale) {
		setPageNo(pageNo);
		setPageScale(pageScale);
	}

	public void setTotalRows(final Map<String, Object> param, final int totalRows) {
		this.totalRows = totalRows;
		totalPages = totalRows / pageSize;

		final int mod = totalRows % pageSize;
		if (mod > 0) {
			totalPages++;
		}
		setCurrentPage(this.currentPage);
		param.put("startRow", this.getStartRow());
		param.put("pageSize", this.getPageSize());
		param.put("endRow", this.getStartRow() + this.getPageSize());
	}
	
	public void setTotalRows( Map<String, Object> param) {
		totalPages = totalRows / pageSize;

		final int mod = totalRows % pageSize;
		if (mod > 0) {
			totalPages++;
		}
		setCurrentPage(this.currentPage);
		param.put("startRow", this.getStartRow());
		param.put("pageSize", this.getPageSize());
		param.put("endRow", this.getStartRow() + this.getPageSize());
	}

	// 可设置页面显示记录条数
	public void setTotalRows(final HashMap<String, Object> param, final int totalRows, int page_size) {
		this.pageSize = page_size;
		this.totalRows = totalRows;
		totalPages = totalRows / pageSize;

		final int mod = totalRows % pageSize;
		if (mod > 0) {
			totalPages++;
		}
		setCurrentPage(this.currentPage);
		param.put("startRow", this.getStartRow());
		param.put("pageSize", this.getPageSize());
		param.put("endRow", this.getStartRow() + this.getPageSize());
	}

	/**
	 * 设置当前页
	 * 
	 * @param currentPage
	 */
	private void setCurrentPage(final int currentPage) {
		// 当前页小于第一页
		if (currentPage < 1) {
			this.currentPage = 1;
		} else if (currentPage > this.totalPages) { // 当前页大于总页数
			this.currentPage = this.totalPages;
		} else {
			this.currentPage = currentPage;
		}
		this.pageNo = this.currentPage;
		this.startRow = (this.currentPage - 1) * this.pageSize;
		if (this.currentPage == 0) {
			this.startRow = 0;
		}
	}

	@SuppressWarnings("unchecked")
	public List getList() {
		return list;
	}

	@SuppressWarnings("unchecked")
	public void setList(final List list) {
		this.list = list;
	}

	/**
	 * @return the totalRows
	 */
	public int getTotalRows() {
		return totalRows;
	}

	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		return totalPages;
	}

	public void setPageNo(final String pageNo) {
		if (pageNo == null || "".equals(pageNo)) {
			this.currentPage = 1;
		} else {
			try {
				this.currentPage = Integer.parseInt(pageNo);
			} catch (final Exception e) {
				this.currentPage = 1;
			}
		}
		this.pageNo = this.currentPage;
	}

	public String getPageScale() {
		return pageScale;
	}

	public void setPageScale(final String pageScale) {
		this.pageScale = pageScale;
		if (pageScale == null || "".equals(pageScale)) {
			this.pageSize = Pager.PAGE_SIZE;
		} else {
			try {
				this.pageSize = Integer.parseInt(pageScale);
			} catch (final Exception e) {
				this.pageSize = Pager.PAGE_SIZE;
			}
		}
		this.pageScale = String.valueOf(this.pageSize);
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getStartRow() {
		return this.startRow;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public int setPageSize(int pageSz) {
		return this.pageSize = pageSz;
	}

	/** Ajxa翻页 */
//	public String getSiAjaxPageHtml() {
//		StringBuffer pageHtml = new StringBuffer("<ul class='pagination'>");
//		if (this.getPageNo() > 1) {
//			if (this.getPageNo() > 5) {
//				pageHtml.append("<li><a href='javascript:;' onclick='goPageByAjax(1)'>首页</a></li>");
//			}
//			pageHtml.append("<li><a href='javascript:;'  onclick='goPageByAjax(" + (this.getPageNo() - 1) + ")'>上一页</a></li>");
//		}
//		for (int i = (this.getPageNo() - 2 <= 0 ? 1 : this.getPageNo() - 2), no = 1; i <= this.getTotalPages() && no < 6; i++, no++) {
//			if (this.getPageNo() == i) {
//				pageHtml.append("<li class='active'><a href='javascript:void(0);' >" + i + "</a></li>");
//			} else {
//				pageHtml.append("<li><a href='javascript:;' onclick='goPageByAjax(" + i + ")'>" + i + "</a></li>");
//			}
//		}
//		if (this.getPageNo() < this.getTotalPages()) {
//			pageHtml.append("<li><a href='javascript:;'  onclick='goPageByAjax(" + (this.getPageNo() + 1) + ")'>下一页</a></li>");
//		}
//		pageHtml.append("</ul>");
//		return pageHtml.toString();
//	}
	
	public static class SiAjaxPageInfo {
		String pageAjaxFunctionName;
		
		public static SiAjaxPageInfo parse(String pageAjaxFunctionName){
			return new SiAjaxPageInfo(pageAjaxFunctionName);
		}
		
		public SiAjaxPageInfo(String pageAjaxFunctionName) {
			super();
			this.pageAjaxFunctionName = pageAjaxFunctionName;
		}

		public String getPageAjaxFunctionName() {
			return pageAjaxFunctionName;
		}

		public void setPageAjaxFunctionName(String pageAjaxFunctionName) {
			this.pageAjaxFunctionName = pageAjaxFunctionName;
		}
	}
	
	
	public String getSiAjaxPageHtml(){
		StringBuffer pageHtml = new StringBuffer("<div class='J-page-wrap pd20 mb45'><div class='base_page'>");
		if(this.currentPage == 1){
			pageHtml.append("<a type='button' class='btn btn-default j_page_prev_btn pull-left disabled'>");
		}else{
			pageHtml.append("<a type='button' class='btn btn-default j_page_prev_btn pull-left' onclick='goPageByAjax("+ (this.currentPage - 1) +")'>");
		}
		pageHtml.append("<i class='fa fa-chevron-left'>上页</i></a>");
		pageHtml.append("<button href='' type='button' class='btn btn-default j_page_info base_page_info pull-left' disabled='disabled'>" + this.currentPage + "/" + this.getTotalPages() + "</button>");
		if(this.currentPage == this.totalPages){
			pageHtml.append("<a type='button' class='btn btn-default j_page_next_btn pull-left disabled'>");
		}else{
			pageHtml.append("<a type='button' class='btn btn-default j_page_next_btn pull-left' onclick='goPageByAjax("+ (this.currentPage + 1) +")'>");
		}
		pageHtml.append("<i class='fa fa-chevron-right'>下页</i></a>");
		pageHtml.append("<input class='form-control base_page_search_input pull-left' id='j_madule_page_search_input' type='text' maxentry="+this.totalPages+">");
		pageHtml.append("<a class='btn btn-default j_madule_page_search_submit pull-left ml5' type='button' onclick='goPageByAjax(this.previousSibling.value)'>Go</a>");
		return pageHtml.toString();
	}
	
	public String getSiAjaxPageHtml(SiAjaxPageInfo pageInfo){
		StringBuffer pageHtml = new StringBuffer("<div class='J-page-wrap pd20 mb45'><div class='base_page'>");
		if(this.currentPage == 1){
			pageHtml.append("<a type='button' class='btn btn-default j_page_prev_btn pull-left disabled'>");
		}else{
			pageHtml.append("<a type='button' class='btn btn-default j_page_prev_btn pull-left' onclick='"+pageInfo.getPageAjaxFunctionName()+"("+ (this.currentPage - 1) +")'>");
		}
		pageHtml.append("<i class='fa fa-chevron-left'></i></a>");
		pageHtml.append("<button href='' type='button' class='btn btn-default j_page_info base_page_info pull-left' disabled='disabled'>" + this.currentPage + "/" + this.getTotalPages() + "</button>");
		if(this.currentPage == this.totalPages){
			pageHtml.append("<a type='button' class='btn btn-default j_page_next_btn pull-left disabled'>");
		}else{
			pageHtml.append("<a type='button' class='btn btn-default j_page_next_btn pull-left' onclick='"+pageInfo.getPageAjaxFunctionName()+"("+ (this.currentPage + 1) +")'>");
		}
		pageHtml.append("<i class='fa fa-chevron-right'></i></a>");
		pageHtml.append("<input class='form-control base_page_search_input pull-left' id='j_madule_page_search_input' type='text' maxentry="+this.totalPages+">");
		pageHtml.append("<a class='btn btn-default j_madule_page_search_submit pull-left ml5' type='button' onclick='"+pageInfo.getPageAjaxFunctionName()+"(this.previousSibling.value)'>Go</a>");
		return pageHtml.toString();
	}

}
