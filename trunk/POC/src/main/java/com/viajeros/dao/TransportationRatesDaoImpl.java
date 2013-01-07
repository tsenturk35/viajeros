package com.viajeros.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.viajeros.entity.Client;
import com.viajeros.entity.TransportationRate;
import com.viajeros.entity.VehicleType;

@SuppressWarnings("unchecked")
@Repository
public class TransportationRatesDaoImpl extends AbstractDaoImpl implements	ITransportationRateDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void updateTransportationRate(TransportationRate transportationRate) {
		updateEntity(transportationRate);
	}

	@Override
	public List<TransportationRate> getAllTransportationRates() {
		return getSession().createQuery(" from TransportationRate ").list();

	}

	public List<VehicleType> getAllVehicleTypeIdList() {
		return getSession().getNamedQuery("VehicleType.getAllVehicleTypeId").list();
	}

	@Override
	public void deleteTransportationRate(long aTransportationRateId) {
		TransportationRate transportationRate = (TransportationRate) getSession()
					.get(TransportationRate.class, aTransportationRateId);
		getSession().delete(transportationRate);
	}

	@Override
	public TransportationRate getTransportationRatesById(long aTransportationRateId) {
		return (TransportationRate) getSession().get(TransportationRate.class, aTransportationRateId);
	}

	@Override
	public List<Client> getClientList() {
		return getSession().createQuery(" from Client ").list();
	}

}
