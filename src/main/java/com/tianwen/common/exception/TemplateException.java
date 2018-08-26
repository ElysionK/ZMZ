package com.tianwen.common.exception;

public class TemplateException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6281507393510114756L;
	
	private String message;

	public TemplateException(String message) {
		super(message);
		System.out.println(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}