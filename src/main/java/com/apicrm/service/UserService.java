package com.apicrm.service;

import org.springframework.stereotype.Service;

import com.apicrm.entity.Role;
import com.apicrm.entity.DkUser;
import com.apicrm.entity.DkUserStatus;
@Service
public interface UserService {
	public Role getOrInsertRole(String roleName);

	public DkUserStatus getOrInserTlcUserStatus(String statusName);

	public DkUser findUserByEmail(String email);
	
	public DkUser saveDkUser(DkUser user);
	
	public DkUser saveDkUser(DkUser user, boolean isEncodePassword);
}
