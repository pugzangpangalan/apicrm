package com.apicrm.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apicrm.entity.TlcUser;
import com.apicrm.service.UserRegisterService;
import com.apicrm.service.utils.RequiredChecker;
import com.apicrm.service.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@RestController
public class RegisterController {
	Gson gson = new Gson();

	@Autowired
	UserRegisterService userRegisterService;

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> register(@RequestBody String requestBody, HttpSession session) {
		StringUtils su = new StringUtils();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("first_name");
		arrayList.add("last_name");
		arrayList.add("email_address");
		arrayList.add("password");
		arrayList.add("role");
		arrayList.add("status");
		JsonElement element = gson.fromJson(requestBody, JsonElement.class);
		JsonObject requestJson = element.getAsJsonObject();
		String required = RequiredChecker.requiredCheck(arrayList, requestJson);
		if (null != required) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(su.genererateReturnMessage("Required Field", required));
		}
		TlcUser user = gson.fromJson(requestBody, TlcUser.class);
		if(null != userRegisterService.findUserByEmail(user.getEmailAddress())) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(su.genererateReturnMessage("Error", "Email address already exists"));
		}
		
		userRegisterService.saveTlcUser(user);
		return ResponseEntity.ok(su.genererateReturnMessage("Message", "User successfully added!"));
	}

}
