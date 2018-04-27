package com.apicrm.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.apicrm.entity.DkUser;
import com.apicrm.repository.DkUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	DkUserRepository dkUserRepository;
	@Override
	public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserBuilder builder = null;
		DkUser dkUser = dkUserRepository.findByEmailAddress(userNameOrEmail);
		if(null != dkUser) {
			builder = org.springframework.security.core.userdetails.User.withUsername(userNameOrEmail);
			builder.password(dkUser.getPassword());
			builder.roles(dkUser.getRole().getRoleName());
		} else {
			throw new UsernameNotFoundException(userNameOrEmail);
		}
		
		
		return builder.build();
	}

}
