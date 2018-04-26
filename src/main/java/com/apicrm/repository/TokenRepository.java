package com.apicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.apicrm.entity.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {
	
	Token findByToken(@Param("token") String token);
}
