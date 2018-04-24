package com.apicrm.entity;

import java.io.Serializable;
import java.util.Date;

public class Tlc implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String tlcId;
	private String address;
	private String customerName;
	private String contactNumber;
	private String siteAccessInfo;
	private Date date;
	private String time;
	private int scopeDocSent;
	private String chorusPortalOrder;
	private String icmsServiceOrder;
	private long teamId;
	private TlcStatus status;
	private String siteVisitOutcome;
	private String comments;
	private int scheduleOnce;
	private int scopingDocCount;
	private Date appointmentDate;
	private TlcProject project;
	private DoorKnockTeam team;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTlcId() {
		return tlcId;
	}

	public void setTlcId(String tlcId) {
		this.tlcId = tlcId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getSiteAccessInfo() {
		return siteAccessInfo;
	}

	public void setSiteAccessInfo(String siteAccessInfo) {
		this.siteAccessInfo = siteAccessInfo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getScopeDocSent() {
		return scopeDocSent;
	}

	public void setScopeDocSent(int scopeDocSent) {
		this.scopeDocSent = scopeDocSent;
	}

	public String getChorusPortalOrder() {
		return chorusPortalOrder;
	}

	public void setChorusPortalOrder(String chorusPortalOrder) {
		this.chorusPortalOrder = chorusPortalOrder;
	}

	public String getIcmsServiceOrder() {
		return icmsServiceOrder;
	}

	public void setIcmsServiceOrder(String icmsServiceOrder) {
		this.icmsServiceOrder = icmsServiceOrder;
	}

	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getScheduleOnce() {
		return scheduleOnce;
	}

	public void setScheduleOnce(int scheduleOnce) {
		this.scheduleOnce = scheduleOnce;
	}

	public int getScopingDocCount() {
		return scopingDocCount;
	}

	public void setScopingDocCount(int scopingDocCount) {
		this.scopingDocCount = scopingDocCount;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public TlcStatus getStatus() {
		return status;
	}

	public void setStatus(TlcStatus status) {
		this.status = status;
	}

	public String getSiteVisitOutcome() {
		return siteVisitOutcome;
	}

	public void setSiteVisitOutcome(String siteVisitOutcome) {
		this.siteVisitOutcome = siteVisitOutcome;
	}

	public TlcProject getProject() {
		return project;
	}

	public void setProject(TlcProject project) {
		this.project = project;
	}

	public DoorKnockTeam getTeam() {
		return team;
	}

	public void setTeam(DoorKnockTeam team) {
		this.team = team;
	}
	
}
