package com.viajeros.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.viajeros.entity.Client;
import com.viajeros.entity.Destination;
import com.viajeros.entity.TransportationRate;
import com.viajeros.entity.VehicleType;

@Repository
public class TransportationRatesDaoImpl extends AbstractDaoImpl implements
		ITransportationRateDao {

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

	public List<String> getAllSourceId() {
		Query query = getSession().getNamedQuery("Destination.getAllSourceId");
		return query.list();

	}
	
	public List<String> getAlldestinationIdList() {
		Query query = getSession().getNamedQuery("Destination.getAllSourceId");
		return query.list();
	}
	
	public List<String> getAllClientIdList() {
		Query query = getSession().getNamedQuery("Client.getAllClientId");
		return query.list();
	}
	
	public List<String> getAllVehicleTypeIdList() {
		Query query = getSession().getNamedQuery("VehicleType.getAllVehicleTypeId");
		return query.list();
	}
	

	@Override
	public void deleteTransportationRate(long userId) {
		try {
			TransportationRate transportationRate = (TransportationRate) getSession()
					.get(TransportationRate.class, userId);
			getSession().delete(transportationRate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public TransportationRate listTransportationRatesById(long anId) {
		TransportationRate transportationRate = null;
		try {
			transportationRate = (TransportationRate) getSession().get(
					TransportationRate.class, anId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transportationRate;
	}

}
