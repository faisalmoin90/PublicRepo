package com.alraedah.assignment.model;

import java.io.Serializable;

public class ErrorVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type = null;
	private String code = null;
	private String message = null;

	public ErrorVO() {
		super();
	}

	public ErrorVO(String type, String code, String message) {
		super();
		this.type = type;
		this.code = code;
		this.message = message;
	}

	public ErrorVO(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
