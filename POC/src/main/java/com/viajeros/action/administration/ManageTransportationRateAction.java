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
import com.viajeros.dao.TransportationRatesDaoImpl;
import com.viajeros.entity.Client;
import com.viajeros.entity.Destination;
import com.viajeros.entity.TransportationRate;
import com.viajeros.entity.VehicleType;

public class ManageTransportationRateAction extends ActionSupport implements
		ModelDriven<TransportationRate> {

	private ManageTransportationRateAction() {
		super();
	}

	private static final long serialVersionUID = -6659925652584240539L;

	private TransportationRate transportationRate = new TransportationRate();
	private List<TransportationRate> transportationRateList = new ArrayList<TransportationRate>();
	private List<Destination> sourceIdList = new ArrayList<Destination>();
	private final List<Destination> destinationIdList = new ArrayList<Destination>();
	private final List<Client> clientIdList = new ArrayList<Client>();
	private final List<VehicleType> vehicletypeIdList = new ArrayList<VehicleType>();

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
	public String delete()
	{
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
	transportationRatesDao.deleteTransportationRate(Long.parseLong( request.getParameter("id")));
	return SUCCESS;
	}
	 
	public String edit()
	{
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
	transportationRate = transportationRatesDao.listTransportationRatesById(Long.parseLong( request.getParameter("id")));
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
