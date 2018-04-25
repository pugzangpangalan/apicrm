package com.apicrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
}
