package com.alraedah.assignment.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.alraedah.assignment.model.ErrorsVO;

@Component
public class ResponseGeneratorUtility {


	public ResponseEntity<Object> responseEntity200(Object object) {
		return ResponseEntity.ok().body(object);
	}

	
	public ResponseEntity<ErrorsVO> responseEntity400(ErrorsVO errors) {
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}


	public ResponseEntity<ErrorsVO> responseEntity500(final ErrorsVO errors) {
		return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
