package com.tianwen.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 索引类
 * 
 * 
 */
public class Query implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String query;

	private String type;
	
	private List<String> type1;
	
	public List<String> getType1() {
		return type1;
	}

	public void setType1(List<String> type1) {
		this.type1 = type1;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
