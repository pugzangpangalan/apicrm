package com.apicrm.entity;

import java.io.Serializable;
import java.util.Date;

public class Tlc implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String tlcId;
	private String address;
	private String customerName;
	private String phoneNumber;
	private String siteAccessInfo;
	private Date date;
	private String time;
	private int scopeDocSent;
	private String chorusPortalOrder;
	private String icmsServiceOrder;
	private long teamId;
	private int statusId;
	private String comments;
	private int scheduleOnce;
	private int scopingDocCount;
	private Date appointmentDate;

	public Tlc(String tlcId) {
		this.tlcId = tlcId;
	}

	public Tlc address(String address) {
		this.address = address;
		return this;
	}

	public Tlc customerName(String customerName) {
		this.customerName = customerName;
		return this;
	}

	public Tlc phoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public Tlc siteAccessInfo(String siteAccessInfo) {
		this.siteAccessInfo = siteAccessInfo;
		return this;
	}

	public Tlc date(Date date) {
		this.date = date;
		return this;
	}

	public Tlc time(String time) {
		this.time = time;
		return this;
	}

	public Tlc scopeDocSent(int scopeDocSent) {
		this.scopeDocSent = scopeDocSent;
		return this;
	}

	public Tlc chorusPortalOrder(String chorusPortalOrder) {
		this.chorusPortalOrder = chorusPortalOrder;
		return this;
	}

	public Tlc icmsServiceOrder(String icmsServiceOrder) {
		this.icmsServiceOrder = icmsServiceOrder;
		return this;
	}

	public Tlc teamId(long teamId) {
		this.teamId = teamId;
		return this;
	}

	public Tlc statusId(int statusId) {
		this.statusId = statusId;
		return this;
	}

	public Tlc comments(String comments) {
		this.comments = comments;
		return this;
	}

	public Tlc scheduleOnce(int scheduleOnce) {
		this.scheduleOnce = scheduleOnce;
		return this;
	}

	public Tlc scopingDocCount(int scopingDocCount) {
		this.scopingDocCount = scopingDocCount;
		return this;
	}

	public Tlc appointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
		return this;
	}

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
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
	
}
