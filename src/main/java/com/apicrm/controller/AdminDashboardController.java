package com.apicrm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apicrm.entity.Tlc;
import com.apicrm.service.TlcService;

@Controller
@RequestMapping(value = "admin")
public class AdminDashboardController {
	
	@Autowired
	private TlcService tlcService;

	@RequestMapping(value = "/")
	public String showAdminDashboard(Map<String, Object> model) {
		model.put("campaignList", tlcService.getAllTlc());
		return "admin/admindashboard";
	}
	
	@RequestMapping(value = "/campaign", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Tlc> getCampains() {
		return tlcService.getAllTlc();
	}
	
	@RequestMapping(value = "/updateCampaign")
	public String updateCampaign(@RequestParam("tlcId") int tlcId, @RequestParam("address") String address) {
		Tlc campaign = new Tlc();
		
		tlcService.updateCampaign(campaign);
		return "redirect:/admin/";
	}
}
