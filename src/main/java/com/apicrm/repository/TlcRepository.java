package com.apicrm.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apicrm.entity.Tlc;

public interface TlcRepository extends JpaRepository<Tlc, Long> {
	
	public Tlc findByTlcId(@Param("tlcId") String tlcId);
	
	@Query("SELECT c FROM Tlc c WHERE c.team.teamName = :teamName")
	public List<Tlc> findByTeamName(@Param("teamName") String teamName);
	
	@Query("SELECT c FROM Tlc c WHERE c.installationDate = :installationDate AND team.teamName = :teamName AND status.statusName = :statusName")
	public List<Tlc> findScheduledOpportunities(@Param("installationDate") Date installationDate, @Param("teamName") String teamName, @Param("statusName") String statusName);
	
	@Query("SELECT c FROM Tlc c WHERE c.team.teamName = :teamName AND c.status.statusName IN :statusName")
	public List<Tlc> findCustomerOpportunities(@Param("teamName") String teamName, @Param("statusName") String[] statusName);
	
}
