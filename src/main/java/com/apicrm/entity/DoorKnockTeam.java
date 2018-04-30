package com.apicrm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class DoorKnockTeam implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "team_id")
	private long teamId;

	@Column(name = "team_name")
	private String teamName;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "status")
	private String status;

	@Column(name = "door_knocker")
	private String doorKnocker;

	@Column(name = "scoper")
	private String scoper;

	public DoorKnockTeam() {
	}
	
	public DoorKnockTeam(String teamName) {
		this.teamName = teamName;
	}

	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDoorKnocker() {
		return doorKnocker;
	}

	public void setDoorKnocker(String doorKnocker) {
		this.doorKnocker = doorKnocker;
	}

	public String getScoper() {
		return scoper;
	}

	public void setScoper(String scoper) {
		this.scoper = scoper;
	}
}
