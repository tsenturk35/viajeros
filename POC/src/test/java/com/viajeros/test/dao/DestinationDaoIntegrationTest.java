package com.viajeros.test.dao;

import com.viajeros.dao.DestinationDaoImpl;
import com.viajeros.dao.IDestinationDao;
import com.viajeros.entity.Destination;

public class DestinationDaoIntegrationTest extends AbstractDaoIntegrationTest{
	
	private IDestinationDao destinationDao;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		destinationDao = new DestinationDaoImpl();
		destinationDao.setSessionFactory(getSessionFactory());
	}
	
	
	public void testUpdateDestination(){
		
		Destination destination = destinationDao.getDestinationById(12l);
		destination.setName("kolkata");
		destinationDao.saveDestination(destination);
		
		Destination updatedDestination = destinationDao.getDestinationById(destination.getDestinationId());
		assertEquals("kolkata", updatedDestination.getName());
		Long version = updatedDestination.getVersion();
		
		updatedDestination.setName("Kolkata1");
		destinationDao.saveDestination(updatedDestination);
		
		 updatedDestination = destinationDao.getDestinationById(destination.getDestinationId());
		 assertEquals("Kolkata1", updatedDestination.getName());
		 assertEquals(++version, updatedDestination.getVersion());
		 
		updatedDestination.setName("Kolkata2");
		updatedDestination.setVersion(1l);
		destinationDao.saveDestination(updatedDestination);
		Destination newDestination = destinationDao.getDestinationById(destination.getDestinationId());
		assertEquals("Kolkata2", newDestination.getName());
		
	}
}
