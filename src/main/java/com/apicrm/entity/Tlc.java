package com.apicrm.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tlc")
public class Tlc implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "tlc_id")
	private String tlcId;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "contact_number")
	private String contactNumber;
	
	@Column(name = "site_access_info")
	private String siteAccessInfo;
	
	@Column(name = "install_date")
	private Date installationDate;
	
	@Column(name = "install_time")
	private String installationTime;
	
	@Column(name = "scope_doc_sent")
	private int scopeDocSent;
	
	@Column(name = "chorus_portal_order")
	private String chorusPortalOrder;
	
	@Column(name = "icms_service_order")
	private String icmsServiceOrder;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "status_id", referencedColumnName = "status_id")
	private TlcStatus status;
	
	@Column(name = "site_visit_outcome")
	private String siteVisitOutcome;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "schedule_once")
	private int scheduleOnce;
	
	@Column(name = "scoping_doc_count")
	private int scopingDocCount;
	
	@Column(name = "appointment_date")
	private Date appointmentDate;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "campaign_id", referencedColumnName = "campaign_id")
	private Campaign campaign;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "team_id", referencedColumnName = "team_id")
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

	public Date getInstallationDate() {
		return installationDate;
	}

	public void setInstallationDate(Date installationDate) {
		this.installationDate = installationDate;
	}

	public String getInstallationTime() {
		return installationTime;
	}

	public void setInstallationTime(String installationTime) {
		this.installationTime = installationTime;
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

	public DoorKnockTeam getTeam() {
		return team;
	}

	public void setTeam(DoorKnockTeam team) {
		this.team = team;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}
	
	public String getFormattedInstallationDate() {
		if(installationDate == null) return "";
		return new SimpleDateFormat("dd/MM/yyyy").format(installationDate);
	}
	
	public String getFormattedAppointmentDate() {
		if(appointmentDate == null) return "";
		return new SimpleDateFormat("dd/MM/yyyy").format(appointmentDate);
	}
	
	public void deepCopy(Tlc to, Tlc from) {
		to.setAddress(from.getAddress());
		to.setCustomerName(from.getCustomerName());
		to.setContactNumber(from.getContactNumber());
		to.setSiteAccessInfo(from.getSiteAccessInfo());
		to.setInstallationDate(from.getInstallationDate());
		to.setInstallationTime(from.getInstallationTime());
		to.setScopeDocSent(from.getScopeDocSent());
		to.setCampaign(from.getCampaign());
		to.setChorusPortalOrder(from.getChorusPortalOrder());
		to.setIcmsServiceOrder(from.icmsServiceOrder);
		to.setTeam(from.getTeam());
		to.setStatus(from.getStatus());
		to.setSiteVisitOutcome(from.getSiteVisitOutcome());
		to.setComments(from.getComments());
		to.setScheduleOnce(from.getScheduleOnce());
		to.setScopeDocSent(from.getScopeDocSent());
		to.setAppointmentDate(from.getAppointmentDate());
	}
	
}
