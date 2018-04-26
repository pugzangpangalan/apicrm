package com.apicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apicrm.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	@Query("SELECT c FROM Role c WHERE LOWER(c.roleName) = :roleName ")
	Role findByRoleName(@Param("roleName") String roleName);
}
