package com.viajeros.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.viajeros.utils.Strings;

@NamedQueries({ @NamedQuery(name = "VehicleType.getAllVehicleTypeId", query = "select vehicleTypeId from VehicleType vehicleType order by vehicleTypeId asc ") })
@Entity
@Table(name = "vehicle_type")
public class VehicleType implements IOperable {

	@Id
	@Column(name = "vehicle_type_id")
	private Long vehicleTypeId;

	@Column(name = "name")
	private String name;

	@Column(name = "capacity")
	private Double capacity;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = TransportationRate.class, mappedBy = "vehicleType")
	private Set<TransportationRate> transportationRates;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = DetentionRate.class, mappedBy = "vehicleType")
	private Set<DetentionRate> detentionRates;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = InvoiceDetails.class, mappedBy = "vehicleType")
	private Set<InvoiceDetails> invoiceDetails;

	public Long getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(Long vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	public Set<TransportationRate> getTransportationRates() {
		return transportationRates;
	}

	public void setTransportationRates(
			Set<TransportationRate> transportationRates) {
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
				+ ((vehicleTypeId == null) ? 0 : vehicleTypeId.hashCode());
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
		VehicleType other = (VehicleType) obj;
		if (vehicleTypeId == null) {
			if (other.vehicleTypeId != null)
				return false;
		} else if (!vehicleTypeId.equals(other.vehicleTypeId))
			return false;
		return true;
	}

	@Override
	public String getPrimaryId() {
		if (null == getVehicleTypeId())
			return Strings.EMPTY;
		return getVehicleTypeId().toString();
	}

}
