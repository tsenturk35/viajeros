package com.viajeros.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_type")
public class VehicleType {

	@Id
	@Column(name = "vehicle_type_id")
	private Long vehicleTypeId;

	@Column(name = "name")
	private String name;

	@Column(name = "capacity")
	private Double capacity;

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

}
