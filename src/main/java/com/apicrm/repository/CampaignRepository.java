package com.apicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.apicrm.entity.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
	Campaign findByCampaignName(@Param("campaignName") String campaignName);
}
