package com.apicrm.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.apicrm.entity.DkUser;
import com.apicrm.entity.DkUserStatus;
import com.apicrm.entity.Role;
import com.apicrm.repository.DkUserRepository;
import com.apicrm.repository.DkUserStatusRepository;
import com.apicrm.repository.RoleRepository;
import com.apicrm.service.UserRegisterService;

@Service
@Transactional
public class UserRegisterServiceImpl implements UserRegisterService {
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	DkUserStatusRepository dKUserStatusRepository;
	@Autowired
	DkUserRepository dKUserRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

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
		DkUserStatus tlcUserStatus = dKUserStatusRepository.findByStatusName(statusName);
		if(null != tlcUserStatus) {
			return tlcUserStatus;
		}
		tlcUserStatus = new DkUserStatus(statusName);
		dKUserStatusRepository.save(tlcUserStatus);
		return tlcUserStatus;
	}

	public DkUser findUserByEmail(String email) {
		return dKUserRepository.findByEmailAddress(email.toLowerCase());
	}

	@Override
	public DkUser saveDkUser(DkUser user) {
		
		return saveDkUser(user,true);
	}
	
	@Override
	public DkUser saveDkUser(DkUser user, boolean isEncodePassword) {
		if (isEncodePassword) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		}
		user.setRole(getOrInsertRole(user.getStrRole().trim()));
		user.setDkUserStatus(getOrInserTlcUserStatus(user.getStrStatusName().trim()));
		return dKUserRepository.save(user);
	}
}
