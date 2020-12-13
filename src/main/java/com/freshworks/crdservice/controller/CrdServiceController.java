package com.freshworks.crdservice.controller;

import java.net.UnknownHostException;

import javax.websocket.server.PathParam;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.freshworks.crdservice.model.CrdServiceModel;
import com.freshworks.crdservice.service.CrdService;

@RestController
@RequestMapping("crd-service")
public class CrdServiceController {

	@Autowired
	CrdService crdService;
	
	@RequestMapping(value={"/createData"}, method= RequestMethod.POST)
	public ResponseEntity<String> createData(@RequestBody CrdServiceModel requestBody) throws UnknownHostException {
		System.out.println("In controller.... createData()");
		crdService.createData(requestBody);
		return ResponseEntity.ok("Success");
	}
	
	@RequestMapping(path={"/readData/{key}"}, method= RequestMethod.GET, produces= "application/json")
	public ResponseEntity<JSONObject> readData(@PathVariable("key") String key) throws UnknownHostException, JsonMappingException, JsonProcessingException {
		System.out.println("In controller.... createData()");
		JSONObject jsonResponse = crdService.readData(key);
		return ResponseEntity.ok(jsonResponse);
	}
	
	@RequestMapping(value={"/deleteData"}, method= RequestMethod.POST)
	public ResponseEntity<String> deleteData(@RequestParam(value="key") String key) throws UnknownHostException {
		System.out.println("In controller.... createData()");
		crdService.deleteData(key);
		return ResponseEntity.ok("Success");
	}
}
