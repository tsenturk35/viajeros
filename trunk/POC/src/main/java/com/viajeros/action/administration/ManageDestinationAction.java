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
	private String test;
	

	public IDestinationDao getDestinationDao() {
		return destinationDao;
	}

	public void setDestinationDao(IDestinationDao destinationDao) {
		this.destinationDao = destinationDao;
	}
	
	@Override
	@Transactional(readOnly=true)
	public String execute(){
		destinationList = (ArrayList<Destination>) destinationDao.getDestinationList();
		test="executed!!";
		return SUCCESS;
	}

	public List<Destination> getDestinationList() {
		return destinationList;
	}

	public void setDestinationList(ArrayList<Destination> destinationList) {
		this.destinationList = destinationList;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
	

	
	

}
