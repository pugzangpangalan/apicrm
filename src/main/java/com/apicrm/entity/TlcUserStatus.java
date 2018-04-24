package com.apicrm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tlc_user_status")
public class TlcUserStatus {
	@Id
	@Column(name = "tlc_user_status_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tlcUserStatusId;
	@Column(name = "status_name")
	private String statusName;
}
