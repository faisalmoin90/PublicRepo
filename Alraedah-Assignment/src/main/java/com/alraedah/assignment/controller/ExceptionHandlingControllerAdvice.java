package com.alraedah.assignment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.alraedah.assignment.exception.BusinessException;
import com.alraedah.assignment.exception.ServicesErrorCodes;
import com.alraedah.assignment.model.ErrorVO;
import com.alraedah.assignment.model.ErrorsVO;
import com.alraedah.assignment.utility.ResponseGeneratorUtility;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class ExceptionHandlingControllerAdvice {
	
	@Autowired
	ResponseGeneratorUtility responseGenerationUtility;
	
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorsVO> unhandleException(Exception exception) {
		log.error("Exception occured{} :::", getExceptionStackTraceAsString(exception));
		return frame500InternalErrorResponse(
		        new BusinessException(ServicesErrorCodes.TECHNICAL_FAILURE, exception));
	}
	
	 
	
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	protected ResponseEntity<ErrorsVO> handleMethodArgumentNotValid(HttpMessageNotReadableException validationException,
	        WebRequest request) {
		log.error("MethodArgumentNotValidException occured={} ::::" ,getExceptionStackTraceAsString(validationException));
		return frame400InternalErrorResponse(new BusinessException(ServicesErrorCodes.INVALID_INPUT), "");
	}
	
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<ErrorsVO> handleMethodNotValid(HttpRequestMethodNotSupportedException validationException,
	        WebRequest request) {
		log.error("MethodArgumentNotValidException occured={} ::::" ,getExceptionStackTraceAsString(validationException));
		return frame400InternalErrorResponse(new BusinessException(ServicesErrorCodes.INVALID_METHOD_TYPE), "");
	}
	
	
	
	@ExceptionHandler(value = HttpMessageConversionException.class)
	protected ResponseEntity<ErrorsVO> handleInputArgumentNotValid(HttpMessageConversionException validationException,
	        WebRequest request) {
		log.error("MethodArgumentNotValidException occured={} ::::" ,getExceptionStackTraceAsString(validationException));
		return frame400InternalErrorResponse(new BusinessException(ServicesErrorCodes.INVALID_INPUT), "");
	}
	
	
	
	@ExceptionHandler(value = MismatchedInputException.class)
	protected ResponseEntity<ErrorsVO> handleInvalidRequestBodyNotValid(MethodArgumentNotValidException validationException,
	        WebRequest request) {
		log.error("handleInvalidRequestBodyNotValid occured={} ::::" ,getExceptionStackTraceAsString(validationException));
		String errorField = validationException.getBindingResult().getFieldError().getField();
		return frame400InternalErrorResponse(new BusinessException(ServicesErrorCodes.INVALID_ARGUMENT), errorField);
	}
	
	
	
	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<ErrorsVO> handleException(BusinessException customerException) {
		log.error("handleException occured ={}::",
		        getExceptionStackTraceAsString(customerException));
		
		return this.responseGenerationUtility
		        .responseEntity400(this.getErrorsList(customerException));
	}
	
	public ResponseEntity<ErrorsVO> frame500InternalErrorResponse(
			BusinessException customerException) {
		ServicesErrorCodes errorCodes = customerException.getErrorCodes();
		ErrorVO error = new ErrorVO(errorCodes.getType(), errorCodes.getCode(), errorCodes.getMessage());
		List<ErrorVO> errorsList = new ArrayList<>();
		errorsList.add(error);
		ErrorsVO errors = new ErrorsVO();
		errors.setErrors(errorsList);
		return this.responseGenerationUtility.responseEntity500(errors);

	}
	public ResponseEntity<ErrorsVO> frame400InternalErrorResponse(
			BusinessException customerException, String errorField) {
		ServicesErrorCodes errorCodes = customerException.getErrorCodes();
		ErrorVO error = new ErrorVO(errorCodes.getType(), errorCodes.getCode(), errorCodes.getMessage().replace("fieldName", errorField));
		List<ErrorVO> errorsList = new ArrayList<>();
		errorsList.add(error);
		ErrorsVO errors = new ErrorsVO();
		errors.setErrors(errorsList);
		return this.responseGenerationUtility.responseEntity400(errors);

	}
	
	private ErrorsVO getErrorsList(BusinessException customerException) {
		ErrorsVO errors = Objects.nonNull(customerException.getErrorsVO()) ? customerException.getErrorsVO()
		        : new ErrorsVO();
		List<ErrorVO> errorsList = Objects.nonNull(errors.getErrors()) ? errors.getErrors() : new ArrayList<>();
		ErrorVO error = new ErrorVO(customerException.getErrorCodes().getCode(), customerException.getMessage());
		errorsList.add(0, error); // Add on the first index
		errors.setErrors(errorsList);

		return errors;
	}
	
	public static String getExceptionStackTraceAsString(Exception ex) {
		if (Objects.nonNull(ex)) {
			String str = ExceptionUtils.getFullStackTrace(ex);
			if (StringUtils.isNotBlank(str)) {
				return str.replaceAll("\\n", "\\\\n").replaceAll("\\r", "\\\\r").replace("\\s", StringUtils.EMPTY);
			} else {
				log.error("Empty exception string for exception : {}", ex.getMessage());
			}
		} else {
			log.error("Exception is null.");
		}
		return StringUtils.EMPTY;
	}

	

}