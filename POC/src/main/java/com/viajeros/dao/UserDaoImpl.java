package com.viajeros.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.viajeros.entity.User;


@Repository
public class UserDaoImpl extends AbstractDaoImpl implements IUserDao {

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
	public User getUserById(String userId) {
		Query query = getSession().getNamedQuery("User.findUserByUserIdAndPassword");
		query.setString("userId", userId);
		return (User) query.uniqueResult();

	}

	
}

