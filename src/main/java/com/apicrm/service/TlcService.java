package com.apicrm.service;

import com.apicrm.entity.Tlc;

public interface TlcService {

	public void saveTlcCsvFile(String path);
	
	public Tlc getTlcByTlcId(String tlcId);
	
}
