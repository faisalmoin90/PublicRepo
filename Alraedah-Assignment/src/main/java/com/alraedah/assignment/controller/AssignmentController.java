package com.alraedah.assignment.controller;


import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alraedah.assignment.constant.APIConstants;
import com.alraedah.assignment.model.CycleDetectionRequest;
import com.alraedah.assignment.service.AssigmentService;
import com.alraedah.assignment.utility.ResponseGeneratorUtility;

import lombok.extern.log4j.Log4j2;

/**
 * @author FaisalMOI
 *
 */
@RestController
@RequestMapping(value =APIConstants.ROOT)
@Log4j2
public class AssignmentController {
	
	@Autowired
	AssigmentService assignmentService;
	
	@Autowired
	private ResponseGeneratorUtility responseGenerationUtility;


	@PutMapping(value = APIConstants.COUNT_CYCLE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> perfectCycle(@Valid @RequestBody CycleDetectionRequest cycleDetectionRequest) {
		 log.info("Reached count-cycle Controller");
		Map<String, Boolean> response =assignmentService.detectCycle(cycleDetectionRequest).getResponseList();
		 return responseGenerationUtility.responseEntity200(response);
	    }
	
}
