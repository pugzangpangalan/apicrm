package com.apicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apicrm.entity.DkUser;

public interface DkUserRepository extends JpaRepository<DkUser, Long> {
	@Query("SELECT c FROM DkUser c WHERE LOWER(c.emailAddress) = :emailAddress ")
	DkUser findByEmailAddress(@Param("emailAddress") String emailAddress);
}
