package com.apicrm.service.impl;

import org.springframework.stereotype.Service;

import com.apicrm.entity.TlcStatus;
import com.apicrm.service.TlcStatusService;

@Service
public class TlcStatusServiceImpl implements TlcStatusService {

	public TlcStatus findByStatusId(String statusId) {
		return new TlcStatus();	
	}
}
