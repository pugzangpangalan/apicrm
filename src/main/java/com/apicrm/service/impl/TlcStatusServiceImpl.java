package com.apicrm.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicrm.entity.TlcStatus;
import com.apicrm.repository.TlcStatusRepository;
import com.apicrm.service.TlcStatusService;

@Service
@Transactional
public class TlcStatusServiceImpl implements TlcStatusService {
	
	@Autowired
	private TlcStatusRepository tlcStatusRepository;

	public TlcStatus findByStatusName(String statusName) {
		return tlcStatusRepository.findByStatusName(statusName);	
	}
}
