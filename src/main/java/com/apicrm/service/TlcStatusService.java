package com.apicrm.service;

import com.apicrm.entity.TlcStatus;

public interface TlcStatusService {
	
	public TlcStatus findByStatusName(String statusName);

}
