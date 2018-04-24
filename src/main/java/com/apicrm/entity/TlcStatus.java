package com.apicrm.entity;

import java.io.Serializable;

public class TlcStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String statusId;
	private String statusName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
