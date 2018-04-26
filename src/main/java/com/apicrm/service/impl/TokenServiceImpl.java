package com.apicrm.service.impl;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicrm.entity.SecretKey;
import com.apicrm.entity.Token;
import com.apicrm.repository.SecretKeyRepository;
import com.apicrm.repository.TokenRepository;
import com.apicrm.service.TokenService;
import com.apicrm.utils.StringUtils;

@Service
public class TokenServiceImpl implements TokenService {
	@Autowired
	SecretKeyRepository secretKeyRepository;
	
	@Autowired
	TokenRepository tokenRepository;
	
	@Override
	public Token getToken(String secretKey) {
		Token token = new Token();
		SecretKey sk = secretKeyRepository.findBySecretKey(secretKey);
		StringUtils util = new StringUtils();
		
		if (!sk.getSecretKey().equals("")) {
			token.setToken(util.generateToken());
			token.setStatus(1); // 1 is active, 2 expired, 3 disabled
			// (2) create a java timestamp object that represents the current time (i.e., a "current timestamp")
		    Calendar calendar = Calendar.getInstance();
		    calendar.add(Calendar.HOUR_OF_DAY,1);
		    
		    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
			token.setExpiration_date(date);
			token = tokenRepository.save(token);
		}
		return token;
	}

	@Override
	public SecretKey getSecretKey() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
