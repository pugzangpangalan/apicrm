package com.apicrm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="secret_key")
public class SecretKey {
	@Id
	@Column(name = "secret_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long secret_id;
	
	@Column(name="secret_key")
	private String secretKey;
	
	@Column(name="status")
	private int status;

	public Long getSecret_id() {
		return secret_id;
	}

	public void setSecret_id(Long secret_id) {
		this.secret_id = secret_id;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
