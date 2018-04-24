package com.apicrm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/crm")
public class ApiController {
	
	
	@RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
	public ResponseEntity<?> generateKeyPair() {
		return ResponseEntity.ok("Hello World");
	}
}
