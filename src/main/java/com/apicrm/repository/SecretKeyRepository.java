package com.apicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.apicrm.entity.SecretKey;

public interface SecretKeyRepository extends JpaRepository<SecretKey, Long> {
	
	SecretKey findBySecretKey(@Param("secretKey") String secretKey);
}
