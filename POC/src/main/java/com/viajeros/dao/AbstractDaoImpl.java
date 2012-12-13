package com.viajeros.dao;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

public abstract class AbstractDaoImpl {

	protected abstract SessionFactory getSessionFactory();

	protected Session getSession() {
		if (getSessionFactory().getCurrentSession() == null)
			throw new IllegalStateException("No Session has not been set before usage");
		return getSessionFactory().getCurrentSession();
	}

	protected Object updateEntity(Object entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	protected Collection<?> updateEntities(Collection<?> entities) {
		if (entities.size() == 0)
			return entities;
		for (Object entity : entities)
			getSession().saveOrUpdate(entity);
		return entities;
	}

	protected void deleteEntity(Object entity) {
		getSession().delete(entity);;
	}

	protected void deleteEntities(Collection<?> entities) {
		if (entities.size() < 1)
			return;

		for (Object entity : entities)
			getSession().delete(entity);
				
	}


}
