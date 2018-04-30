package com.apicrm.service;

import com.apicrm.entity.DoorKnockTeam;

public interface DoorKnockTeamService {
	
	public DoorKnockTeam findByTeamName(String name);
	
	public DoorKnockTeam findByTeamId(long teamId);
	
	public DoorKnockTeam save(DoorKnockTeam doorKnockTeam);

}
