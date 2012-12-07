package com.viajeros.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.viajeros.entity.User;



public class UserDaoImpl extends AbstractDaoImpl implements IUserDao {

	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

    public User getUserById(String userId) {
            Session session = getSession();
            Query query = session.getNamedQuery("User.findUserByUserIdAndPassword");
            query.setString("userId", userId);
            List<?> user = query.list();
            session.close();
            if (user.size() > 0)
                    return (User) user.get(0);
            return null;
    }

	
}

