package com.apicrm.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.apicrm.entity.TlcStatus;

public interface TlcStatusRepository extends JpaRepository<TlcStatus, Serializable> {

	TlcStatus findByStatusName(@Param("statusName") String statusName);
}
