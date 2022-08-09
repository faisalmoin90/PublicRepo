package com.alraedah.assignment.model;

import java.util.Map;

import javax.validation.constraints.NotNull;

import com.alraedah.assignment.utility.RequestDeserializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize(using = RequestDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CycleDetectionRequest {
	
	@NotNull
	private Map<String, int[]> inputList;

}
