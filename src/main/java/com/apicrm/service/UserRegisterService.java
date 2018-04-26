package com.apicrm.service;

import org.springframework.stereotype.Service;

import com.apicrm.entity.Role;
import com.apicrm.entity.TlcUser;
import com.apicrm.entity.TlcUserStatus;
@Service
public interface UserRegisterService {
	public Role getOrInsertRole(String roleName);

	public TlcUserStatus getOrInserTlcUserStatus(String statusName);

	public TlcUser findUserByEmail(String email);
	
	public TlcUser saveTlcUser(TlcUser user);
}
