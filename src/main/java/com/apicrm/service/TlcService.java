package com.apicrm.service;

import java.util.List;

import com.apicrm.entity.Tlc;

public interface TlcService {

	public void saveTlcCsvFile(String path);
	
	public Tlc getTlcByTlcId(String tlcId);

	public List<Tlc> getAllTlc();
	
}
