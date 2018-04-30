package com.apicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.apicrm.entity.DoorKnockTeam;

public interface DoorKnockTeamRepository extends JpaRepository<DoorKnockTeam, Long> {
	DoorKnockTeam findByTeamId(@Param("teamId") String teamId);
	
	DoorKnockTeam findByTeamName(@Param("teamName") String teamName);
}
