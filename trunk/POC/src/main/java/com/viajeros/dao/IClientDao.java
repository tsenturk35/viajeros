package com.viajeros.dao;

import java.util.List;

import com.viajeros.entity.Client;

public interface IClientDao {
	
	public List<Client> getClientList();

	public void updateClient(Client aClient);

	public Client getClientById(long anId);

	public void deleteClient(long anId);

}
