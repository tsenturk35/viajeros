package com.viajeros.action.administration;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.viajeros.dao.ITransportationRateDao;
import com.viajeros.entity.TransportationRate;

public class ManageTransportationRateAction extends ActionSupport implements
		ModelDriven<TransportationRate> {

	public ManageTransportationRateAction() {
		super();
	}

	private static final long serialVersionUID = -6659925652584240539L;

	private TransportationRate transportationRate = new TransportationRate();
	private List<TransportationRate> transportationRateList = new ArrayList<TransportationRate>();
	private List<String> sourceIdList = new ArrayList<String>();
	private List<String> destinationIdList = new ArrayList<String>();
	private List<String> clientIdList = new ArrayList<String>();
	private List<String> vehicletypeIdList = new ArrayList<String>();

	@Autowired
	private ITransportationRateDao transportationRatesDao;

	@Override
	public TransportationRate getModel() {
		return transportationRate;
	}

	@Transactional(readOnly = false, rollbackFor = Throwable.class)
	public String add() {
		transportationRatesDao.updateTransportationRate(transportationRate);
		return SUCCESS;
	}

	@Transactional(readOnly = true)
	public String list() {
		transportationRateList = transportationRatesDao
				.getAllTransportationRates();
		return SUCCESS;
	}

	@Transactional(readOnly = true)
	public String sourceIdList() {
		sourceIdList = transportationRatesDao.getAllSourceId();
		return SUCCESS;
	}

	@Transactional(readOnly = true)
	public String destinationIdList() {
		destinationIdList = transportationRatesDao.getAlldestinationIdList();
		return SUCCESS;
	}
	
	@Transactional(readOnly = true)
	public String clientIdList() {
		clientIdList = transportationRatesDao.getAllClientIdList();
		return SUCCESS;
	}
	
	public List<String> getDestinationIdList() {
		return destinationIdList;
	}

	public void setDestinationIdList(List<String> destinationIdList) {
		this.destinationIdList = destinationIdList;
	}

	public List<String> getClientIdList() {
		return clientIdList;
	}

	public void setClientIdList(List<String> clientIdList) {
		this.clientIdList = clientIdList;
	}

	public List<String> getVehicletypeIdList() {
		return vehicletypeIdList;
	}

	public void setVehicletypeIdList(List<String> vehicletypeIdList) {
		this.vehicletypeIdList = vehicletypeIdList;
	}

	@Transactional(readOnly = true)
	public String vehicleTypeIdList() {
		vehicletypeIdList = transportationRatesDao.getAllVehicleTypeIdList();
		return SUCCESS;
	}

	public List<String> getSourceIdList() {
		return sourceIdList;
	}

	public void setSourceIdList(List<String> sourceIdList) {
		this.sourceIdList = sourceIdList;
	}
//---------Ritesh plz leave this HttpServletRequest.. i would change it once the application is up and running.. 
//	some things need to be worked here.. would do it later
	
	
	public String delete() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		transportationRatesDao.deleteTransportationRate(Long.parseLong(request
				.getParameter("id")));
		return SUCCESS;
	}

	public String edit() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		transportationRate = transportationRatesDao
				.listTransportationRatesById(Long.parseLong(request
						.getParameter("id")));
		return SUCCESS;
	}

	public TransportationRate getTransportationRate() {
		return transportationRate;
	}

	public void setTransportationRate(TransportationRate aTransportationRate) {
		this.transportationRate = aTransportationRate;
	}

	//
	public List<TransportationRate> getTransportationRateList() {
		return transportationRateList;
	}

	public void setTransportationRateList(
			List<TransportationRate> aTransportationRateList) {
		this.transportationRateList = aTransportationRateList;
	}

	public ITransportationRateDao getTransportationRatesDao() {
		return transportationRatesDao;
	}

	public void setTransportationRatesDao(
			ITransportationRateDao transportationRatesDao) {
		this.transportationRatesDao = transportationRatesDao;
	}

}
