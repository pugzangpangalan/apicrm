package com.apicrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicrm.entity.TlcProject;
import com.apicrm.repository.TlcProjectRepository;
import com.apicrm.service.TlcProjectService;

@Service
public class TlcProjectServiceImpl implements TlcProjectService {

	@Autowired
	private TlcProjectRepository tlcProjectRepository;
	
	public TlcProject findByProjectName(String projectName) {
		TlcProject tlcProject = tlcProjectRepository.findByProjectName(projectName);
		return tlcProject != null ? tlcProject : new TlcProject();
	}
	
	public TlcProject findProjectById(long id){
		return tlcProjectRepository.findOne(id);
		
	}
}
