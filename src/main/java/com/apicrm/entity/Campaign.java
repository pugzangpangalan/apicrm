package com.apicrm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "campaign")
public class Campaign implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "campaign_id")
	private long campaignId;

	@Column(name = "campaign_name")
	private String campaignName;
	
	@Column(name = "description")
	private String campaignDescription;

	public long getProjectId() {
		return campaignId;
	}

	public void setProjectId(long projectId) {
		this.campaignId = projectId;
	}

	public String getProjectName() {
		return campaignName;
	}

	public void setProjectName(String projectName) {
		this.campaignName = projectName;
	}

	public String getProjectDescription() {
		return campaignDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.campaignDescription = projectDescription;
	}

}
