package com.alraedah.assignment.service.impl;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alraedah.assignment.model.CycleDetectionRequest;
import com.alraedah.assignment.model.CycleDetectionResponse;
import com.alraedah.assignment.model.Node;
import com.alraedah.assignment.service.AssigmentService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AssigmentServiceImpl implements AssigmentService {

	@Override
	public CycleDetectionResponse detectCycle(CycleDetectionRequest cycleDetectionRequestList) {
		log.info("Inside Count Cycle");
		Map<String, Boolean> responseList = new LinkedHashMap<String, Boolean>();
		for (Map.Entry<String, int[]> request : cycleDetectionRequestList.getInputList().entrySet()) {
			if (request.getValue().length!=0) {
				Node head = null;
				boolean checkLoop = true;
				LinkedList<Node> linkedList = new LinkedList<>();
				for (int i = 0; i < request.getValue().length; i++) {
					head = new Node(request.getValue()[i], null);
					linkedList.add(head);
					if (request.getValue()[i] > request.getValue().length - 1) {
						checkLoop = false;
					}
				}
				if (checkLoop) {
					for (Node inputNode : linkedList) {
						inputNode.next = linkedList.get(inputNode.data);
					}
				}

				responseList.put(request.getKey(), checkLoop ? detectCycle(linkedList.getFirst()) : false);
			} else {
				// for Empty Array
				responseList.put(request.getKey(), true);
			}

		}
		CycleDetectionResponse cycleDetectionResponse = new CycleDetectionResponse();
		cycleDetectionResponse.setResponseList(responseList);
		return cycleDetectionResponse;
	}

	public static boolean detectCycle(Node head) {
		Node curr = head;
		Node headNode = head;
		while (curr != null) {
			if (curr.next == headNode) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}

}
