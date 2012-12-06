package com.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.entity.AuditStamp;

@Entity
@Table(name = "ordersheet")
public class TransportationRate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trans_rate_id")
	private Long transportationRateId;

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
	
	@Embedded
	private AuditStamp auditStamp;

	public Long getTransportationRateId() {
		return transportationRateId;
	}

	public void setTransportationRateId(Long transportationRateId) {
		this.transportationRateId = transportationRateId;
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
		result = prime
				* result
				+ ((transportationRateId == null) ? 0 : transportationRateId
						.hashCode());
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
		TransportationRate other = (TransportationRate) obj;
		if (transportationRateId == null) {
			if (other.transportationRateId != null)
				return false;
		} else if (!transportationRateId.equals(other.transportationRateId))
			return false;
		return true;
	}
	
	
}
