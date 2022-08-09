package com.alraedah.assignment.exception;


import static com.alraedah.assignment.constant.APIConstants.TECHNICAL;

public enum ServicesErrorCodes  {

	TECHNICAL_FAILURE(TECHNICAL, "1", "Technical Failure"),
	INVALID_ARGUMENT(TECHNICAL, "2", "[fieldName] is invalid"),
	INVALID_INPUT(TECHNICAL, "3", "RequestBody is invalid"),
	INVALID_METHOD_TYPE(TECHNICAL, "4", "Invalid Method Type, please use PUT");
	
	
	private String type;
	private String code;
	private String message;

	private ServicesErrorCodes() {

	}

	ServicesErrorCodes(String type, String code, String message) {
		this.type = type;
		this.code = code;
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String toString() {
		return name() + ": " + getCode();
	}

}
