package com.viajeros.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.viajeros.utils.Strings;



@Entity
@Table(name = "trans_rate")
public class TransportationRate implements IOperable {
	
	@Version
	private Long version;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trans_rate_id")
	private Long transportationRateId;

	@Column(name = "src_id")
	private Long sourceId;	
	
	@Column(name = "destn_id")
	private Long destinationId;
	
	@Column(name = "client_id")
	private Long clientId;
	
	@Column(name = "vehicle_type_id")
	private Long vehicleTypeId;
	
	@Column(name = "amount")
	private Double amount;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Destination.class)
	@JoinColumn(name = "destn_id", referencedColumnName = "destn_id", insertable = false, updatable = false)
	private Destination destination;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Client.class)
	@JoinColumn(name = "client_id", referencedColumnName = "client_id", insertable = false, updatable = false)
	private Client client;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = VehicleType.class)
	@JoinColumn(name = "vehicle_type_id", referencedColumnName = "vehicle_type_id", insertable = false, updatable = false)
	private VehicleType vehicleType;
	
	
	
//	@Embedded
//	private AuditStamp auditStamp;

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

//	public AuditStamp getAuditStamp() {
//		return auditStamp;
//	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

//	public void setAuditStamp(AuditStamp auditStamp) {
//		this.auditStamp = auditStamp;
//	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
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

	@Override
	public String getPrimaryId() {
		if(null== getTransportationRateId())
			return Strings.EMPTY;
		return getTransportationRateId().toString();
	}
	
	
}
