package com.apicrm.service;

import java.util.Date;
import java.util.List;

import com.apicrm.entity.Tlc;

public interface TlcService {

	public void saveTlcCsvFile(String path);
	
	public Tlc getTlcByTlcId(String tlcId);

	public List<Tlc> getAllTlc();
	
	public String exportCsvFile(String campaignId, boolean openAfterCreate);

	public String updateCampaign(Tlc tlc);

	public List<Tlc> findByTeamName(String teamName);


	public List<Tlc> findScheduledOpportunities(Date date, String team, String status);

	public List<Tlc> getCustomerOpportunities(String team, String status);

	public Tlc updateTlc(Tlc tlc);
	
}
