package com.apicrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicrm.entity.Campaign;
import com.apicrm.repository.CampaignRepository;
import com.apicrm.service.CampaignService;

@Service
public class CampaignServiceImpl implements CampaignService {

	@Autowired
	private CampaignRepository campaignRepository;
	
	public Campaign findByCampaignName(String campaignName) {
		Campaign campaign = campaignRepository.findByCampaignName(campaignName);
		return campaign != null ? campaign : new Campaign();
	}
	
	public Campaign findCampaignById(long id){
		return campaignRepository.getOne(id);
		
	}
}
