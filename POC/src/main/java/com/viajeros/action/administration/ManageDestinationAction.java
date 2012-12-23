package com.viajeros.action.administration;

import java.beans.DesignMode;
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
	private List<Destination> destinationList;
	private Destination destination;
	
	public IDestinationDao getDestinationDao() {
		return destinationDao;
	}

	public void setDestinationDao(IDestinationDao destinationDao) {
		this.destinationDao = destinationDao;
	}
	

	@Transactional(readOnly=true)
	public String list(){
		destinationList = (ArrayList<Destination>) destinationDao.getDestinationList();
		return SUCCESS;
	}
	
	@Transactional(readOnly=true)
	public String view(){
		
		return INPUT;
	}
	
	@Transactional(readOnly=false, rollbackFor=Throwable.class)
	public String save(){
		destinationDao.saveDestination(destination);
		destinationList = destinationDao.getDestinationList();
		return SUCCESS;
	}
	
	@Transactional(readOnly=false, rollbackFor=Throwable.class)
	public String delete(){
		destinationList = (ArrayList<Destination>) destinationDao.getDestinationList();
		return SUCCESS;
	}
	
	
	@Override
	public void validate() {
		super.validate();
		if(destination==null){
			addActionMessage("Destination not set!!");
			return;
		}
		
		if(null==destination.getName() || destination.getName().trim().isEmpty())
			addFieldError("name", "Name is required");
				
	}

	public List<Destination> getDestinationList() {
		return destinationList;
	}

	public void setDestinationList(List<Destination> destinationList) {
		this.destinationList = destinationList;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	

}
