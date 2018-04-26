package com.apicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apicrm.entity.TlcUserStatus;

public interface TlcUserStatusRepository extends JpaRepository<TlcUserStatus, Long> {
	@Query("SELECT c FROM TlcUserStatus c WHERE LOWER(c.statusName) = :statusName ")
	TlcUserStatus findByStatusName(@Param("statusName") String statusName);
}
