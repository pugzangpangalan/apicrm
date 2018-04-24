package com.apicrm.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import com.apicrm.entity.Role;
import com.google.gson.annotations.SerializedName;

@Table(name = "tlc_user")
public class TlcUser {
	@Id
	@Column(name = "tlc_user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tlcUserId;
	@Value("first_name")
	@SerializedName("first_name")
	private String firstName;
	@Value("last_name")
	@SerializedName("last_name")
	private String lastName;
	@Value("email_address")
	@SerializedName("email_address")
	private String emailAddress;
	@SerializedName("password")
	@Value("password")
	private String password;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "role_name", referencedColumnName = "role_name")
	private Role role;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "status_name", referencedColumnName = "status_name")
	private TlcUserStatus tlcUserStatus;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public TlcUserStatus getTlcUserStatus() {
		return tlcUserStatus;
	}

	public void setTlcUserStatus(TlcUserStatus tlcUserStatus) {
		this.tlcUserStatus = tlcUserStatus;
	}
}
