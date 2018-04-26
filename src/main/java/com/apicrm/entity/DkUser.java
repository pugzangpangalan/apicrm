package com.apicrm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Value;

import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "dk_user")
public class DkUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "dk_user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dKUserId;
	
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
	@Transient
	@SerializedName("role")
	private String strRole;
	@Transient
	@SerializedName("status")
	private String strStatusName;
	@SerializedName("role_obj")
	@ManyToOne(optional = false)
	@JoinColumn(name = "role_name", referencedColumnName = "role_name")
	private Role role;
	
	@SerializedName("status_name_obj")
	@ManyToOne(optional = false)
	@JoinColumn(name = "status_name", referencedColumnName = "status_name")
	private DkUserStatus dkUserStatus;

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

	

	public DkUserStatus getDkUserStatus() {
		return dkUserStatus;
	}

	public void setDkUserStatus(DkUserStatus dkUserStatus) {
		this.dkUserStatus = dkUserStatus;
	}

	public Long getdKUserId() {
		return dKUserId;
	}

	public void setdKUserId(Long dKUserId) {
		this.dKUserId = dKUserId;
	}

	public String getStrRole() {
		return strRole;
	}

	public void setStrRole(String strRole) {
		this.strRole = strRole;
	}

	public String getStrStatusName() {
		return strStatusName;
	}

	public void setStrStatusName(String strStatusName) {
		this.strStatusName = strStatusName;
	}
}
