package com.tianwen.common.entity;

public class ValidationEngineResponseJson {
	private String filedId;
	private boolean ok;
	private String msg;
	
	
	
	public ValidationEngineResponseJson(String filedId) {
		super();
		this.filedId = filedId;
	}
	public String getFiledId() {
		return filedId;
	}
	public void setFiledId(String filedId) {
		this.filedId = filedId;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
}
