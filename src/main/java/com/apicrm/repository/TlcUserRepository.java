package com.apicrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apicrm.entity.TlcUser;

public interface TlcUserRepository extends JpaRepository<TlcUser, Long> {

}
