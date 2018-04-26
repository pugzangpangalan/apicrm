package com.apicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apicrm.entity.TlcUser;

public interface TlcUserRepository extends JpaRepository<TlcUser, Long> {
	@Query("SELECT c FROM TlcUser c WHERE LOWER(c.emailAddress) = :emailAddress ")
	TlcUser findByEmailAddress(@Param("emailAddress") String emailAddress);
}
