package com.viajeros.test.dao;

import junit.framework.TestCase;

import org.hibernate.SessionFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class AbstractDaoIntegrationTest extends TestCase{
	
	
	private static SessionFactory sessionFactory;
	
	static {
		initSessionFactory();
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		getSessionFactory().getCurrentSession().beginTransaction();
	}


	private static void initSessionFactory()  {
		try{
			AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("hibernate-config-test.xml");
			sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	@Override
	public void runBare() throws Throwable {
	   try{
		   super.runBare();
	   }catch(Exception e){
		   getSessionFactory().getCurrentSession().getTransaction().rollback();
		   e.printStackTrace();
		   throw e;
	   }
	}
	

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		getSessionFactory().getCurrentSession().getTransaction().commit();
	}


}
