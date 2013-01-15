package com.viajeros.action.administration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.viajeros.dao.IClientDao;
import com.viajeros.entity.Client;
import com.viajeros.utils.Strings;

public class ManageClientAction extends AbstractAdminAction {

	private static final long serialVersionUID = 7635766941969310827L;

	public ManageClientAction() {
		super();
	}

	@Autowired
	private IClientDao clientDao;
	private List<Client> clientList;

	public IClientDao getClientDao() {
		return clientDao;
	}

	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	private Client client;

	@Transactional(readOnly = true)
	public String list() {
		clientList = clientDao.getClientList();
		return SUCCESS;

	}

	@Transactional(readOnly = true)
	public String view() {
		if (!Strings.hasValue(getPrimaryId()))
			return INPUT;

		client = clientDao.getClientById(Long.valueOf(getPrimaryId()));
		if (null == client)
			addActionError("Error: Client not found!");

		return INPUT;
	}

	@Transactional(readOnly = false, rollbackFor = Throwable.class)
	public String save() {
		clientDao.updateClient(client);
		clientList = clientDao.getClientList();
		addActionMessage("Client saved successfully.");
		return SUCCESS;
	}

	@Transactional(readOnly = false, rollbackFor = Throwable.class)
	public String delete() {
		
		if(!Strings.hasValue(getPrimaryId()))
			return INPUT;
		clientDao.deleteClient(Long.valueOf(getPrimaryId()));
		clientList = clientDao.getClientList();
		addActionMessage("Client deleted successfully!");
		return SUCCESS;
	}

	@Override
	public String getEntityName() {
		return "Client";
	}

}
