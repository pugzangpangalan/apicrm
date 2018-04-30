package com.apicrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apicrm.entity.Tlc;

public interface TlcRepository extends JpaRepository<Tlc, Long> {
	
	public Tlc findByTlcId(@Param("tlcId") String tlcId);
	
	@Query("SELECT c FROM Tlc c WHERE c.team.teamName = :teamName")
	public List<Tlc> findByTeamName(@Param("teamName") String teamName);
	
}
