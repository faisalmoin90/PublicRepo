package com.alraedah.assignment.model;

import javax.validation.constraints.Pattern;

import com.alraedah.assignment.constant.APIConstants;
import com.fasterxml.jackson.annotation.JsonInclude;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request {
	
	@Pattern(regexp = APIConstants.REGEX_LIST_NAME, message = APIConstants.INVALID_ARGUMENT)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String key;
	
	
	@Pattern(regexp = APIConstants.REGEX_NUMERIC, message = APIConstants.INVALID_ARGUMENT)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private int[] value;

}
