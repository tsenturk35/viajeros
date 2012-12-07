package com.viajeros.dao;



import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

public abstract class AbstractDaoImpl {

	public abstract SessionFactory getSessionFactory();
	
	protected Session getSession() {
		return getSessionFactory().openSession();
	}
       
}
