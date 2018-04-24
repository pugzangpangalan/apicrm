package com.apicrm.entity;

import java.io.Serializable;

public class DoorKnockTeam implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String teamName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}
