package com.apicrm.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicrm.entity.Role;
import com.apicrm.entity.DkUser;
import com.apicrm.entity.DkUserStatus;
import com.apicrm.repository.RoleRepository;
import com.apicrm.repository.DkUserRepository;
import com.apicrm.repository.DkUserStatusRepository;
import com.apicrm.service.UserRegisterService;

@Service
@Transactional
public class UserRegisterServiceImpl implements UserRegisterService {
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	DkUserStatusRepository tlcUserStatusRepository;
	@Autowired
	DkUserRepository tlcUserRepository;

	public Role getOrInsertRole(String roleName) {
		roleName = roleName.toLowerCase();
		Role role = roleRepository.findByRoleName(roleName);
		if (null != role) {
			return role;
		}
		role = new Role(roleName);
		roleRepository.save(role);
		return role;
	}

	public DkUserStatus getOrInserTlcUserStatus(String statusName) {
		statusName = statusName.toLowerCase();
		DkUserStatus tlcUserStatus = tlcUserStatusRepository.findByStatusName(statusName);
		if(null != tlcUserStatus) {
			return tlcUserStatus;
		}
		tlcUserStatus = new DkUserStatus(statusName);
		tlcUserStatusRepository.save(tlcUserStatus);
		return tlcUserStatus;
	}

	public DkUser findUserByEmail(String email) {
		return tlcUserRepository.findByEmailAddress(email.toLowerCase());
	}

	@Override
	public DkUser saveDkUser(DkUser user) {
		user.setRole(getOrInsertRole(user.getStrRole().trim()));
		user.setDkUserStatus(getOrInserTlcUserStatus(user.getStrStatusName().trim()));
		return tlcUserRepository.save(user);
	}
}
