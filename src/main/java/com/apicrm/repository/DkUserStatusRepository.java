package com.apicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apicrm.entity.DkUserStatus;

public interface DkUserStatusRepository extends JpaRepository<DkUserStatus, Long> {
	@Query("SELECT c FROM DkUserStatus c WHERE LOWER(c.statusName) = :statusName ")
	DkUserStatus findByStatusName(@Param("statusName") String statusName);
}
