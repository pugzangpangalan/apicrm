package com.apicrm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dk_user_status")
public class DkUserStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "dk_user_status_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dkUserStatusId;
	@Column(name = "status_name")
	private String statusName;

	public DkUserStatus() {
	}

	public DkUserStatus(String statusName) {
		this.statusName = statusName;
	}

	public Long getDkUserStatusId() {
		return dkUserStatusId;
	}

	public void setDkUserStatusId(Long dkUserStatusId) {
		this.dkUserStatusId = dkUserStatusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
