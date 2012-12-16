package com.viajeros.dao;

import java.util.List;

import com.viajeros.entity.TransportationRate;
import com.viajeros.entity.VehicleType;

public interface IVehicleTypeDao {
	
	public List<VehicleType> getAllVehicleTypeList();
	
	void updateVehicleType(VehicleType vehicleType);

	void deleteVehicleType(long aVehicleTypeId);

	VehicleType listVehicleTypeById(long aVehicleTypeId);

}
