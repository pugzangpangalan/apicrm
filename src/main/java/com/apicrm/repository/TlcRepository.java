package com.apicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.apicrm.entity.Tlc;

public interface TlcRepository extends JpaRepository<Tlc, Long> {
	
	public Tlc findByTlcId(@Param("tlcId") String tlcId);
	
}
