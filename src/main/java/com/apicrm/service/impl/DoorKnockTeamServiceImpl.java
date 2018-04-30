package com.apicrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicrm.entity.DoorKnockTeam;
import com.apicrm.repository.DoorKnockTeamRepository;
import com.apicrm.service.DoorKnockTeamService;

@Service
public class DoorKnockTeamServiceImpl implements DoorKnockTeamService {

	@Autowired
	private DoorKnockTeamRepository doorKnockTeamRepository;

	@Override
	public DoorKnockTeam findByTeamName(String teamName) {
		DoorKnockTeam doorKnockTeam = doorKnockTeamRepository.findByTeamName(teamName);
		return doorKnockTeam != null ? doorKnockTeam : new DoorKnockTeam();
	}

	@Override
	public DoorKnockTeam findByTeamId(long teamId) {
		return doorKnockTeamRepository.getOne(teamId);
	}

	@Override
	public DoorKnockTeam save(DoorKnockTeam doorKnockTeam) {

		return doorKnockTeamRepository.save(doorKnockTeam);
	}
}
