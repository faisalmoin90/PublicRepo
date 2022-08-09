package com.alraedah.assignment.service;

import javax.validation.Valid;

import com.alraedah.assignment.model.CycleDetectionRequest;
import com.alraedah.assignment.model.CycleDetectionResponse;

public interface AssigmentService  {
	
	public CycleDetectionResponse detectCycle(@Valid CycleDetectionRequest cycleDetectionRequest);


}
