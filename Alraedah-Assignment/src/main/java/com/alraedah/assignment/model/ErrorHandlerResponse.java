package com.alraedah.assignment.model;


import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class ErrorHandlerResponse implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String flag;

	public ErrorHandlerResponse(String flag, String code, String type, String description, int httpStatus) {
		super();
		this.flag = flag;
		this.code = code;
		this.type = type;
		this.description = description;
		this.httpStatus = httpStatus;
	}

	private String code;
	private String type;
	private String description;
	private int httpStatus;

	public ErrorHandlerResponse() {

	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HttpStatus getHttpStatus() {
		return HttpStatus.valueOf(httpStatus);
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
