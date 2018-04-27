package com.apicrm.service;

import com.apicrm.entity.Campaign;

public interface CampaignService {
	
	public Campaign findByCampaignName(String name);
	
	public Campaign findCampaignById(long userId);

}
