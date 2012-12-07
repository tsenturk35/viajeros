package com.viajeros.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AuditStamp {

	@Column(name = "last_updated_by")
	private String lastUpdatedBy;

	@Column(name = "last_updated_dt")
	private Date lastUpdatedDate;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_dt")
	private Date createdDate;

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public static AuditStamp getNewInstance() {
		AuditStamp auditStamp = new AuditStamp();
		auditStamp.setLastUpdatedDate(new Date());
		return auditStamp;
	}

}
