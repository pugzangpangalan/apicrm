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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apicrm.entity.DkUser;
import com.apicrm.service.DoorKnockTeamService;
import com.apicrm.service.UserService;
import com.apicrm.utils.RequiredChecker;
import com.apicrm.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@RestController
public class RegisterController {
	Gson gson = new Gson();

	@Autowired
	UserService userRegisterService;
	
	@Autowired
	DoorKnockTeamService doorKnockTeamService;

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
			return ResponseEntity.status(HttpStatus.FORBIDDEN)
					.body(su.genererateReturnMessage("Required Field", required));
		}
		DkUser user = gson.fromJson(requestBody, DkUser.class);
		user.setDoorKnockTeam(doorKnockTeamService.findByTeamName(user.getDoorKnockTeamName()));
		if (null != userRegisterService.findUserByEmail(user.getEmailAddress())) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN)
					.body(su.genererateReturnMessage("Error", "Email address already exists"));
		}

		userRegisterService.saveDkUser(user);
		return ResponseEntity.ok(su.genererateReturnMessage("Message", "User successfully added!"));
	}

	@RequestMapping(value = "/logoutapi", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void logout(HttpSession session) {
		session.invalidate();
	}

}
