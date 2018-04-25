package com.apicrm.service;

import com.apicrm.entity.TlcProject;

public interface TlcProjectService {
	
	public TlcProject findByProjectName(String name);
	
	public TlcProject findProjectById(long userId);

}
