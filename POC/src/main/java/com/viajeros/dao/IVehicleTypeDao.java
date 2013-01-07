package com.viajeros.dao;

import java.util.List;

import com.viajeros.entity.VehicleType;

public interface IVehicleTypeDao {
	
	public List<VehicleType> getVehicleTypeList();
	
	void updateVehicleType(VehicleType vehicleType);

	void deleteVehicleType(long aVehicleTypeId);

	VehicleType getVehicleTypeById(long aVehicleTypeId);

}
