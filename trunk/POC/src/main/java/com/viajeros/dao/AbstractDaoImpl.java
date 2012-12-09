package com.viajeros.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class AbstractDaoImpl {

	private final SessionFactory sessionFactory;

	public AbstractDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Session getSession() {
		return getSessionFactory().openSession();
	}

	public Object updateEntity(Object entity) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		try {
			session.saveOrUpdate(entity);
			transaction.commit();
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
		return entity;
	}

	public List<?> updateEntities(List<?> entities) {
		if (entities.size() == 0)
			return entities;
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		try {
			for (Object entity : entities)
				session.saveOrUpdate(entity);
			transaction.commit();
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
		return entities;
	}

	public void updateEntities(Set<?> entities) {
		if (entities.size() == 0)
			return;
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		try {
			for (Object entity : entities)
				session.saveOrUpdate(entity);
			transaction.commit();
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public void deleteEntity(Object entity) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		try {
			session.delete(entity);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public void deleteEntities(List<?> entities) {
		if (entities.size() < 1)
			return;
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		try {
			for (Object entity : entities)
				session.delete(entity);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

}
