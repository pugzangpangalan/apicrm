package com.apicrm.service.impl;

import org.springframework.stereotype.Service;

import com.apicrm.entity.DoorKnockTeam;
import com.apicrm.service.DoorKnockTeamService;

@Service
public class DoorKnockTeamServiceImpl implements DoorKnockTeamService {

	public DoorKnockTeam findByTeamName(String name) {
		return new DoorKnockTeam();
	}
}
