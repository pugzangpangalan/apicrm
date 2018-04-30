package com.apicrm.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apicrm.entity.AuthenticationForm;




@Controller
public class AuthenticationController {
	@RequestMapping("/login")
	public String loginPage(Map<String, Object> model, @RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			model.put("errorMsg", "Username or password is incorrect!");
		}
		model.put("loginForm", new AuthenticationForm());
		return "login";
	}
}
