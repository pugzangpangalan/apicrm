package com.apicrm.entity;

import java.io.Serializable;

public class TlcProject implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String projectName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
