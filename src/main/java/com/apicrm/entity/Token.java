package com.apicrm.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="token")
public class Token {
	@Id
	@Column(name = "token_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tokenId;
	
	@Column(name="token")
	private String token;
	
	@Column(name="expiration_date")
	private Date expirationDate;
	
	@Column(name="status")
	private int status;

	public Long getTokenId() {
		return tokenId;
	}

	public void setTokenId(Long roleId) {
		this.tokenId = roleId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiration_date() {
		return expirationDate;
	}

	public void setExpiration_date(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
