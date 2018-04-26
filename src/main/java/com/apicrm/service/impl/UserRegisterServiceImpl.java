package com.apicrm.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicrm.entity.Role;
import com.apicrm.entity.TlcUser;
import com.apicrm.entity.TlcUserStatus;
import com.apicrm.repository.RoleRepository;
import com.apicrm.repository.TlcUserRepository;
import com.apicrm.repository.TlcUserStatusRepository;
import com.apicrm.service.UserRegisterService;

@Service
@Transactional
public class UserRegisterServiceImpl implements UserRegisterService {
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	TlcUserStatusRepository tlcUserStatusRepository;
	@Autowired
	TlcUserRepository tlcUserRepository;

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

	public TlcUserStatus getOrInserTlcUserStatus(String statusName) {
		statusName = statusName.toLowerCase();
		TlcUserStatus tlcUserStatus = tlcUserStatusRepository.findByStatusName(statusName);
		if(null != tlcUserStatus) {
			return tlcUserStatus;
		}
		tlcUserStatus = new TlcUserStatus(statusName);
		tlcUserStatusRepository.save(tlcUserStatus);
		return tlcUserStatus;
	}

	public TlcUser findUserByEmail(String email) {
		return tlcUserRepository.findByEmailAddress(email.toLowerCase());
	}

	@Override
	public TlcUser saveTlcUser(TlcUser user) {
		user.setRole(getOrInsertRole(user.getStrRole().trim()));
		user.setTlcUserStatus(getOrInserTlcUserStatus(user.getStrStatusName().trim()));
		return tlcUserRepository.save(user);
	}
}
