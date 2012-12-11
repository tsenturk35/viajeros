package com.viajeros.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.viajeros.entity.TransportationRate;

public class TransportationRatesDaoImpl extends AbstractDaoImpl implements ITransportationRateDao {


	public TransportationRatesDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public void updateTransportationRate(TransportationRate transportationRate) {
			Session session = getSession();
			session.save(transportationRate);
		
	}

	public List<TransportationRate> getAllTransportationRates() {
		Session session = getSession();
		Query query = session
				.createQuery("from TransportationRate order by trans_rate_id asc");
		List result = query.list();
		session.close();
		return result;
	}

}
