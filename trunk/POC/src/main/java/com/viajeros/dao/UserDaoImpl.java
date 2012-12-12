package com.viajeros.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
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

