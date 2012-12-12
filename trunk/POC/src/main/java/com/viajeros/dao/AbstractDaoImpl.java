package com.viajeros.dao;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

public abstract class AbstractDaoImpl {

	public abstract SessionFactory getSessionFactory();

	public Session getSession() {
		if (getSessionFactory().getCurrentSession() == null)
			throw new IllegalStateException("No Session has not been set before usage");
		return getSessionFactory().getCurrentSession();
	}

	public Object updateEntity(Object entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	public Collection<?> updateEntities(Collection<?> entities) {
		if (entities.size() == 0)
			return entities;
		for (Object entity : entities)
			getSession().saveOrUpdate(entity);
		return entities;
	}

	public void deleteEntity(Object entity) {
		getSession().delete(entity);;
	}

	public void deleteEntities(Collection<?> entities) {
		if (entities.size() < 1)
			return;

		for (Object entity : entities)
			getSession().delete(entity);
				
	}


}
