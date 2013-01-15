package com.viajeros.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.viajeros.entity.Client;

@SuppressWarnings("unchecked")
@Repository
public class ClientDaoImpl extends AbstractDaoImpl implements IClientDao {

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
	public List<Client> getClientList() {
		return getSession().createQuery(" from Client ").list();
	}

	@Override
	public void updateClient(Client aClient) {
		updateEntity(aClient);
	}

	@Override
	public Client getClientById(long aClientId) {
		return (Client) getSession().get(Client.class, aClientId);
	}

	@Override
	public void deleteClient(long aClientId) {
		Client client = (Client) getSession()
				.get(Client.class, aClientId);
	getSession().delete(client);
	}

}
