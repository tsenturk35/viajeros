package com.viajeros.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.viajeros.entity.AuditStamp;

@Entity
@Table(name = "deten_rate")
public class DetentionRate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "deten_rate_id")
	private Long detentionRateId;

	@Column(name = "src_id")
	private Long sourceId;

	@Column(name = "dest_id")
	private Long destinationId;

	@Column(name = "client_id")
	private Long clientId;

	@Column(name = "vehicle_typ_id")
	private Long vehicleTypeId;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "deten_days")
	private int detentionDays;

	@Embedded
	private AuditStamp auditStamp;

	public Long getDetentionRateId() {
		return detentionRateId;
	}

	public void setDetentionRateId(Long detentionRateId) {
		this.detentionRateId = detentionRateId;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public Long getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Long destinationId) {
		this.destinationId = destinationId;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Long getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(Long vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public int getDetentionDays() {
		return detentionDays;
	}

	public void setDetentionDays(int detentionDays) {
		this.detentionDays = detentionDays;
	}

	public AuditStamp getAuditStamp() {
		return auditStamp;
	}

	public void setAuditStamp(AuditStamp auditStamp) {
		this.auditStamp = auditStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((detentionRateId == null) ? 0 : detentionRateId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetentionRate other = (DetentionRate) obj;
		if (detentionRateId == null) {
			if (other.detentionRateId != null)
				return false;
		} else if (!detentionRateId.equals(other.detentionRateId))
			return false;
		return true;
	}

}
