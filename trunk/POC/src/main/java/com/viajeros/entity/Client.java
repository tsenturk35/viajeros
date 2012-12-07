package com.viajeros.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@Column(name = "client_id")
	private Long clientId;

	@Column(name = "client_name")
	private String clientName;

	@Column(name = "address")
	private String address;
	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = TransportationRate.class, mappedBy = "client")
	private Set<TransportationRate> transportationRates;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = DetentionRate.class, mappedBy = "client")
	private Set<DetentionRate> detentionRates;

	
	
	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<TransportationRate> getTransportationRates() {
		return transportationRates;
	}

	public void setTransportationRates(Set<TransportationRate> transportationRates) {
		this.transportationRates = transportationRates;
	}

	public Set<DetentionRate> getDetentionRates() {
		return detentionRates;
	}

	public void setDetentionRates(Set<DetentionRate> detentionRates) {
		this.detentionRates = detentionRates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((clientId == null) ? 0 : clientId.hashCode());
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
		Client other = (Client) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		return true;
	}

}
