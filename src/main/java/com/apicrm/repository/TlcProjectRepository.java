package com.apicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.apicrm.entity.TlcProject;

public interface TlcProjectRepository extends JpaRepository<TlcProject, Long> {
	TlcProject findByProjectName(@Param("projectName") String projectName);
}
