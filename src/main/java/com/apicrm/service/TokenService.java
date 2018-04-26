package com.apicrm.service;

import com.apicrm.entity.SecretKey;
import com.apicrm.entity.Token;

public interface TokenService {
	
	public Token getToken(String secretKey);
	public SecretKey getSecretKey();
	
}
