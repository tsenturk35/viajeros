package com.viajeros.action.administration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;
import com.viajeros.dao.IDestinationDao;
import com.viajeros.entity.Destination;

public class ManageDestinationAction extends ActionSupport {
	
	private static final long serialVersionUID = -295199890861770511L;
	
	public ManageDestinationAction() {
		super();
	}

	@Autowired
	private IDestinationDao destinationDao;
	private ArrayList<Destination> destinationList;
	
	public IDestinationDao getDestinationDao() {
		return destinationDao;
	}

	public void setDestinationDao(IDestinationDao destinationDao) {
		this.destinationDao = destinationDao;
	}
	

	@Transactional(readOnly=true)
	public String list(){
		destinationList = (ArrayList<Destination>) destinationDao.getDestinationList();
		System.out.println("In list");
		return SUCCESS;
	}

	public List<Destination> getDestinationList() {
		return destinationList;
	}

	public void setDestinationList(ArrayList<Destination> destinationList) {
		this.destinationList = destinationList;
	}

}
