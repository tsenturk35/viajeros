package com.viajeros.test.dao;

import com.viajeros.dao.TransportationRatesDaoImpl;
import com.viajeros.entity.TransportationRate;



public class TransportationRatesInegrationTest extends AbstractDaoIntegrationTest {
	
	private TransportationRatesDaoImpl transportationRatesDao;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		transportationRatesDao = new TransportationRatesDaoImpl();
		transportationRatesDao.setSessionFactory(getSessionFactory());
		
	}
	
	public void testUpdateTransportationRate(){
		TransportationRate transportationRate = new TransportationRate();
		transportationRatesDao.updateTransportationRate(transportationRate);
		assertNotNull(transportationRatesDao.getAllTransportationRates());
	}
	
}
