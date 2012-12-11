package com.viajeros.action.administration;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.viajeros.dao.ITransportationRateDao;
import com.viajeros.dao.TransportationRatesDaoImpl;
import com.viajeros.entity.TransportationRate;

public class ManageTransportationRateAction extends ActionSupport implements
		ModelDriven<TransportationRate> {

	private static final long serialVersionUID = -6659925652584240539L;

	private TransportationRate transportationRate = new TransportationRate();
	private List<TransportationRate> transportationRateList = new ArrayList<TransportationRate>();
	private ITransportationRateDao transportationRatesDao;

	@Override
	public TransportationRate getModel() {
		return transportationRate;
	}

	public String add() {
		transportationRatesDao.updateTransportationRate(transportationRate);
		return SUCCESS;
	}

	public String list() {
		transportationRateList = transportationRatesDao.getAllTransportationRates();
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

	public void setTransportationRateList(List<TransportationRate> aTransportationRateList) {
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
