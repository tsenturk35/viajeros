package com.viajeros.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.viajeros.entity.DetentionRate;

@SuppressWarnings("unchecked")
@Repository
public class DetentionRatesDaoImpl extends AbstractDaoImpl implements	IDetentionRateDao {

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
	public List<DetentionRate> getAllDetentionRates() {
		return getSession().createQuery(" from DetentionRate ").list();
	}

	@Override
	public void updateDetentionRate(DetentionRate detentionRate) {
		updateEntity(detentionRate);
		
	}

	@Override
	public DetentionRate getDetentionRatesById(long aTransportationRateId) {
		return (DetentionRate) getSession().get(DetentionRate.class, aTransportationRateId);
	}

	@Override
	public void deleteDetentionRate(long aDetentionRateId) {
		DetentionRate detentionRate = (DetentionRate) getSession()
				.get(DetentionRate.class, aDetentionRateId);
	getSession().delete(detentionRate);
		
	}

}
