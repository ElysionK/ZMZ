package com.tianwen.core.backstage.entity;

/**
 * 注册码
 * @author hubo
 *
 */
public class RegistCode {
	/** 有效 */
	public static int VALID = 1;
	
	/** 无效 */
	public static int UN_VALIDE = 0;

	private Integer id;
	
	private String registCode;
	
	private Integer status;
	
	private String userPhone;
	
	public RegistCode() {}
	
	public RegistCode(String registCode) {
		this.registCode = registCode;
		this.status = VALID;
	}
	
	public RegistCode(String registCode, Integer status, String userPhone) {
		this.registCode = registCode;
		this.status = status;
		this.userPhone = userPhone;
	}

	public static int getVALID() {
		return VALID;
	}

	public static void setVALID(int vALID) {
		VALID = vALID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRegistCode() {
		return registCode;
	}

	public void setRegistCode(String registCode) {
		this.registCode = registCode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	
	
}
