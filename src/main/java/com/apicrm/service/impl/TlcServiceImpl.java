package com.apicrm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicrm.common.ApiCrmUtil;
import com.apicrm.entity.Tlc;
import com.apicrm.helper.FileImportHelper;
import com.apicrm.repository.TlcRepository;
import com.apicrm.service.TlcService;

@Service
public class TlcServiceImpl implements TlcService {

	@Autowired
	private FileImportHelper fileImportHelper;
	
	@Autowired
	private TlcRepository tlcRepository;
	
	public void saveTlcCsvFile(String path) {
		List<Tlc> tlcList = fileImportHelper.traverseTlcCsv(path);
		
		for(Tlc tlc : tlcList) {
			tlc = tlcRepository.findByTlcId(tlc.getTlcId()) == null? tlc : tlcRepository.findByTlcId(tlc.getTlcId());
			tlcRepository.save(tlc);
			tlcRepository.flush();
		}
		
		removeCsvFile();
	}
	
	public void removeCsvFile() {
		
	}

	@Override
	public Tlc getTlcByTlcId(String tlcId) {
		return tlcRepository.findByTlcId(tlcId);
	}
	
	@Override
	public List<Tlc> getAllTlc() {
		return tlcRepository.findAll();
	}
	
	@Override
	public String exportCsvFile(String campaignId, boolean openAfterCreate) {
		String fileName = fileImportHelper.generateCsvFile(getAllTlc(), "campaign"+campaignId);
		
		if(!fileName.isEmpty() && openAfterCreate) {
			fileImportHelper.openFile(fileName);
		}
		return fileName;
	}
	
	@Override
	public String updateCampaign(Tlc tlc) {
		Tlc campaign = tlcRepository.findByTlcId(tlc.getTlcId());
		if(campaign != null) {
			campaign.deepCopy(campaign, tlc);
			tlcRepository.saveAndFlush(campaign);
		}
		return campaign.getTlcId();
	}
	
	@Override
	public List<Tlc> findByTeamName(String teamName) {
		return tlcRepository.findByTeamName(teamName);
	}
	
	@Override
	public List<Tlc> findScheduledOpportunities(Date date, String team, String status) {
		return tlcRepository.findScheduledOpportunities(date, team, status);
	}

	@Override
	public List<Tlc> getCustomerOpportunities(String team, String status) {
		List<Tlc> tlcList = null;
		if (ApiCrmUtil.isNullOrEmpty(status)) {
			tlcList = getAllTlc();
		} else {
			String[] statusNames = status.split(",");
			tlcList = tlcRepository.findCustomerOpportunities(team, statusNames);
			
		}
		return tlcList;
		
	}
	
	@Override
	public Tlc updateTlc(Tlc tlc) {
		Optional<Tlc> tlcDb = tlcRepository.findById(tlc.getId());
		tlc.deepCopy(tlcDb.get(), tlc);
		tlcRepository.save(tlcDb.get());
		return tlcDb.get();
	}
	
}
