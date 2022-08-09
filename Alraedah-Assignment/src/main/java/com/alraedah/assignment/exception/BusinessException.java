package com.alraedah.assignment.exception;

import org.springframework.http.HttpStatus;

import com.alraedah.assignment.interfaces.DataFields;
import com.alraedah.assignment.model.ErrorHandlerResponse;
import com.alraedah.assignment.model.ErrorVO;
import com.alraedah.assignment.model.ErrorsVO;

/**
 * @author FaisalMOI
 *
 */
public class BusinessException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private Throwable throwable;
	private DataFields dataField;
	private ServicesErrorCodes errorCodes;
	private ErrorsVO errorsVO;
	private ErrorVO errorVO;
	private String[] messages;

	private HttpStatus statusCode;
	private ErrorHandlerResponse errorHandlerResponse;

	public BusinessException(Throwable throwable) {
		super(throwable);
		this.throwable = throwable;
	}

	public BusinessException(ServicesErrorCodes errorCodes) {
		super(errorCodes.toString());
		this.errorCodes = errorCodes;
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(ServicesErrorCodes errorCodes, String... messages) {
		super(errorCodes.toString());
		this.errorCodes = errorCodes;
		this.messages = messages;
	}

	public BusinessException(ServicesErrorCodes errorCodes, Throwable throwable) {
		super(errorCodes.toString(), throwable);
		this.errorCodes = errorCodes;
		this.throwable = throwable;
	}

	public BusinessException(ErrorsVO errorsVO, HttpStatus statusCode) {
		this.errorsVO = errorsVO;
		this.statusCode = statusCode;
	}

	public BusinessException(String message, Throwable throwable) {
		super(message, throwable);
		this.throwable = throwable;
	}

	public BusinessException(ServicesErrorCodes errorCodes, Throwable throwable, String financialId) {
		super(errorCodes.toString(), throwable);
		this.errorCodes = errorCodes;
		this.throwable = throwable;
	}

	public BusinessException(ServicesErrorCodes errorCodes, ErrorsVO errorsVO) {
		super(errorCodes.toString());
		this.errorCodes = errorCodes;
		this.errorsVO = errorsVO;
	}

	public BusinessException(ServicesErrorCodes errorCodes, ErrorsVO errorsVO, Throwable throwable) {
		super(errorCodes.toString(), throwable);
		this.errorCodes = errorCodes;
		this.errorsVO = errorsVO;
		this.throwable = throwable;
	}

	public Throwable getThrowable() {
		return this.throwable;
	}

	
	public DataFields getDataField() {
		return this.dataField;
	}

	
	public ServicesErrorCodes getErrorCodes() {
		return this.errorCodes;
	}

	public ErrorsVO getErrorsVO() {
		return this.errorsVO;
	}

	public void setErrorsVO(ErrorsVO errorsVO) {
		this.errorsVO = errorsVO;
	}

	public ErrorVO getErrorVO() {
		return this.errorVO;
	}

	public void setErrorVO(ErrorVO errorVO) {
		this.errorVO = errorVO;
	}

	public HttpStatus getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public ErrorHandlerResponse getErrorHandlerResponse() {
		return this.errorHandlerResponse;
	}

	public void setErrorHandlerResponse(ErrorHandlerResponse errorHandlerResponse) {
		this.errorHandlerResponse = errorHandlerResponse;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	public void setDataField(DataFields dataField) {
		this.dataField = dataField;
	}

	public void setErrorCodes(ServicesErrorCodes errorCodes) {
		this.errorCodes = errorCodes;
	}

	
	public String[] getMessages() {
		return this.messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages;
	}

}
