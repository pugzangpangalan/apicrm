package com.apicrm.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.apicrm.entity.TlcStatus;
import com.apicrm.service.TlcStatusService;

@Service
@Transactional
public class TlcStatusServiceImpl implements TlcStatusService {

	public TlcStatus findByStatusId(String statusId) {
		return new TlcStatus();	
	}
}
