package com.freshworks.crdservice.service;

import java.net.UnknownHostException;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freshworks.crdservice.model.CrdServiceModel;
import com.freshworks.crdservice.repository.CrdRepository;

@Service("crdService")
public class CrdService {
	
	@Autowired
	CrdRepository crdRepository;
	
	public void createData(CrdServiceModel request) throws UnknownHostException {
		System.out.println("In service layer....");
		CrdServiceModel crdServiceModel = crdRepository.save(new CrdServiceModel(request.getKey(), request.getValue()));
		System.out.println("Value : "+crdServiceModel.getValue());
		System.out.println("Data saved");
	}
	
	public JSONObject readData(String key) throws UnknownHostException, JsonMappingException, JsonProcessingException {
		System.out.println("In service layer....");
		/*
		 * Optional<CrdServiceModel> jsonResponse = crdRepository.findById(key);
		 * System.out.println(jsonResponse); ObjectMapper mapper = new ObjectMapper();
		 * JsonNode jsonNode = mapper.readTree(jsonResponse.toString());
		 */
		
		JSONObject jsonResponse = crdRepository.findByKey(key);
		System.out.println("jsonResponse  : "+jsonResponse);
		return jsonResponse;
	}
	
	public void deleteData(String key) throws UnknownHostException {
		System.out.println("In service layer....");
		crdRepository.deleteByKey(key);
		System.out.println("Data saved");
	}
}
