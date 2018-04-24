package com.apicrm.service.impl;

import org.springframework.stereotype.Service;

import com.apicrm.entity.TlcProject;
import com.apicrm.service.TlcProjectService;

@Service
public class TlcProjectServiceImpl implements TlcProjectService {

	public TlcProject findByProjectName(String name) {
		return new TlcProject();
	}
}
