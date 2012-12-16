package com.viajeros.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.viajeros.entity.TransportationRate;
import com.viajeros.entity.VehicleType;

@Repository
public class VehicleTypeDaoImpl extends AbstractDaoImpl implements
		IVehicleTypeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public List<VehicleType> getAllVehicleTypeList() {
		return getSession().createQuery(" from VehicleType ").list();
	}

	@Override
	public void updateVehicleType(VehicleType vehicleType) {
		updateEntity(vehicleType);

	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void deleteVehicleType(long aVehicleTypeId) {
		try {
			VehicleType vehicleType = (VehicleType) getSession()
					.get(VehicleType.class, aVehicleTypeId);
			getSession().delete(vehicleType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public VehicleType listVehicleTypeById(long aVehicleTypeId) {
		VehicleType vehicleType = null;
		try {
			vehicleType = (VehicleType) getSession().get(
					VehicleType.class, aVehicleTypeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicleType;
	}



}
