package com.apicrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apicrm.common.ApiCrmUtil;
import com.apicrm.entity.Tlc;
import com.apicrm.service.TlcService;

@RestController
@RequestMapping(value = "/api/opportunities")
public class ApiOpportunitiesController {

	@Autowired
	private TlcService tlcService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Tlc> getCampaign() {
		return tlcService.getAllTlc();
	}
	
	@RequestMapping(value = "/schedule/{date}/{team}/{status}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Tlc> getScheduledOpportunities(@PathVariable("date") String date, @PathVariable("team") String team, @PathVariable("status") String status) {
		return tlcService.findScheduledOpportunities(ApiCrmUtil.parseFormatterdDate(date, "ddMMyyyy"), team, status);
	}
	
	@RequestMapping(value = "/customer/{team}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Tlc> getCustomerOpportunities(@PathVariable("team") String team) {
		return tlcService.getCustomerOpportunities(team, "");
	}
	
	@RequestMapping(value = "/customer/{team}/{status}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Tlc> getCustomerOpportunities(@PathVariable("team") String team, @PathVariable("status") String status) {
		return tlcService.getCustomerOpportunities(team, status);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Tlc getToken(@RequestBody Tlc tlc) {
		
		return tlcService.updateTlc(tlc);
    }

	@RequestMapping(value = "/opportunity/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Tlc getOpportunity(@PathVariable("id") String tlcId) {
		return tlcService.getTlcByTlcId(tlcId);
	}
	
}
