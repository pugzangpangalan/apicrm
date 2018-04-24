package com.apicrm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apicrm.entity.TlcUser;
import com.apicrm.repository.RoleRepository;
import com.google.gson.Gson;

@RestController
public class RegisterController {
	Gson gson = new Gson();
	
	@Autowired
	RoleRepository roleRepository;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> register(@RequestBody String requestBody, HttpSession session) {
		TlcUser user = gson.fromJson(requestBody, TlcUser.class);
		
		
		return ResponseEntity.ok(gson.toJson(user));
	}

}
