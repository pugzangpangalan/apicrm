package com.apicrm.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apicrm.common.AlertStyleMessages;
import com.apicrm.common.ApiCrmUtil;
import com.apicrm.entity.DkUser;
import com.apicrm.entity.Tlc;
import com.apicrm.helper.DoorKnockersMessageHelper;
import com.apicrm.service.DoorKnockTeamService;
import com.apicrm.service.CampaignService;
import com.apicrm.service.TlcService;
import com.apicrm.service.TlcStatusService;
import com.apicrm.service.UserService;

@Controller
@RequestMapping(value = "admin")
public class AdminDashboardController {
	
	@Autowired
	private TlcService tlcService;
	
	@Autowired
	private CampaignService projectService;	
	
	@Autowired
	private DoorKnockTeamService dktService;
	
	@Autowired
	private TlcStatusService statusService;
	
	@Autowired
	private DoorKnockersMessageHelper dkmHelper;
	
	@Autowired
	private UserService userService;
	

	@RequestMapping(value = "/")
	public String showAdminDashboard(Map<String, Object> model, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		DkUser dkUser = userService.findUserByEmail(authentication.getName());
		
		List<Tlc> tlcList = tlcService.getAllTlc();
		if(dkUser != null/* && !ApiCrmUtil.isNullOrEmpty(dkUser.getDoorKnockTeamName())*/) {
			tlcList = tlcService.findByTeamName(dkUser.getDoorKnockTeam().getTeamName());
		}
		
		model.put("campaignList", tlcList);
		return "admin/admindashboard";
	}
	
	@RequestMapping(value = "/campaign", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Tlc> getCampains() {
		return tlcService.getAllTlc();
	}
	
	@RequestMapping(value = "/updateCampaign")
	public String updateCampaign(@RequestParam("tlcId") String tlcId, @RequestParam("address") String address, 
			 @RequestParam("customerName") String customerName,  @RequestParam("contactNumber") String contactNumber, 
			 @RequestParam("siteAccessInfo") String siteAccessInfo,  @RequestParam("installationDate") String installationDate, 
			 @RequestParam("installationTime") String installationTime,  @RequestParam("scopeDocSent") String scopeDocSent,
			 @RequestParam("tlcProject") String tlcProject,  @RequestParam("chorusPortalOrder") String chorusPortalOrder, 
			 @RequestParam("icmsServiceOrder") String icmsServiceOrder,  @RequestParam("team") String team, 
			 @RequestParam("status") String status,  @RequestParam("siteVisitOutcome") String siteVisitOutcome, 
			 @RequestParam("comments") String comments,  @RequestParam("scheduleOnce") String scheduleOnce, 
			 @RequestParam("scopingDocCount") String scopingDocCount,  @RequestParam("appointmentDate") String appointmentDate, 
			 Map<String, Object> model) {
		
		Tlc campaign = new Tlc();
		campaign.setTlcId(tlcId);
		campaign.setAddress(address);
		campaign.setCustomerName(customerName);
		campaign.setContactNumber(contactNumber);
		campaign.setSiteAccessInfo(siteAccessInfo);
		campaign.setInstallationTime(installationTime);
		campaign.setChorusPortalOrder(chorusPortalOrder);
		campaign.setIcmsServiceOrder(icmsServiceOrder);
		campaign.setSiteVisitOutcome(siteVisitOutcome);
		campaign.setComments(comments);
		
		if(!ApiCrmUtil.isNullOrEmpty(installationDate)) {
			campaign.setInstallationDate(ApiCrmUtil.parseDate(installationDate));
		}
		
		if(!ApiCrmUtil.isNullOrEmpty(scopeDocSent) ) {
			campaign.setScopeDocSent(Integer.parseInt(scopeDocSent));
		}
		
		if(!ApiCrmUtil.isNullOrEmpty(tlcProject)) {
			campaign.setCampaign(projectService.findByCampaignName(tlcProject));
		}
		
		if(!ApiCrmUtil.isNullOrEmpty(team)) {
			campaign.setTeam(dktService.findByTeamName(team));
		}
		
		if(!ApiCrmUtil.isNullOrEmpty(status)) {
			campaign.setStatus(statusService.findByStatusName(status));
		}
		
		if(!ApiCrmUtil.isNullOrEmpty(scheduleOnce)) {
			campaign.setScheduleOnce(Integer.parseInt(scheduleOnce));
		}
		
		if(!ApiCrmUtil.isNullOrEmpty(scopingDocCount)) {
			campaign.setScopingDocCount(Integer.parseInt(scopingDocCount));
		}
		
		if(!ApiCrmUtil.isNullOrEmpty(appointmentDate)) {
			campaign.setAppointmentDate(ApiCrmUtil.parseDate(appointmentDate));
		}
		
		String campaignId = tlcService.updateCampaign(campaign);
		if(!ApiCrmUtil.isNullOrEmpty(campaignId)) {
			
			model.put("msgCss", AlertStyleMessages.SUCCESS.getValue());
			model.put("msgDetails", campaignId.concat(": ").concat(dkmHelper.get("campaign.update.success")));
		}
		
		model.put("campaignList", tlcService.getAllTlc());
		return "admin/admindashboard";
	}
	
}
