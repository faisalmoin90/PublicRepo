package com.alraedah.assignment.utility;

import java.io.IOException;
import java.util.Map;

import com.alraedah.assignment.model.CycleDetectionRequest;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestDeserializer extends JsonDeserializer<CycleDetectionRequest> {
	
	
	@Override
    public CycleDetectionRequest deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
		TypeReference<Map<String, int[]>> typeRef  = new TypeReference<Map<String, int[]>>() {};
		Map<String, int[]> mapRequest = objectMapper.readValue(jp, typeRef);
		CycleDetectionRequest request= new CycleDetectionRequest();
		request.setInputList(mapRequest);
		return request;
    }
}

