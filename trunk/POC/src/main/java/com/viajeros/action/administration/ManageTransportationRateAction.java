package com.viajeros.action.administration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.viajeros.dao.IDestinationDao;
import com.viajeros.dao.ITransportationRateDao;
import com.viajeros.dao.IVehicleTypeDao;
import com.viajeros.entity.Client;
import com.viajeros.entity.Destination;
import com.viajeros.entity.TransportationRate;
import com.viajeros.entity.VehicleType;
import com.viajeros.utils.Strings;


public class ManageTransportationRateAction extends AbstractAdminAction {

	public ManageTransportationRateAction() {
		super();
	}

	private static final long serialVersionUID = -6659925652584240539L;

	private TransportationRate transportationRate = new TransportationRate();
	private List<TransportationRate> transportationRateList = new ArrayList<TransportationRate>();
	
	private List<Destination> destinationIdList;
	private List<Client> clientIdList;
	private List<VehicleType> vehicletypeIdList;

	@Autowired
	private ITransportationRateDao transportationRatesDao;
	@Autowired
	private IVehicleTypeDao vehicleTypeDao;
	@Autowired
	private IDestinationDao destinationDao;

	@Transactional(readOnly = false, rollbackFor = Throwable.class)
	public String save() {
		transportationRatesDao.updateTransportationRate(transportationRate);
		transportationRateList = transportationRatesDao.getAllTransportationRates();
		addActionMessage("Transportation Rate saved successfully.");
		return SUCCESS;
	}

	@Transactional(readOnly = true)
	public String view() {

		destinationIdList = destinationDao.getDestinationList();
		clientIdList = transportationRatesDao.getClientList();
		vehicletypeIdList = vehicleTypeDao.getVehicleTypeList();
		
		if(!Strings.hasValue(getPrimaryId()))
			return INPUT;

		transportationRate = transportationRatesDao.getTransportationRatesById(Long.valueOf(getPrimaryId()));
		if(null==transportationRate)
			addActionError("Error: Transportation Rate not found!");
		return INPUT;
	}

	@Transactional(readOnly = true)
	public String list() {
		transportationRateList = transportationRatesDao.getAllTransportationRates();
		return SUCCESS;
	}

	public List<Destination> getDestinationIdList() {
		return destinationIdList;
	}

	public void setDestinationIdList(List<Destination> destinationIdList) {
		this.destinationIdList = destinationIdList;
	}

	public List<Client> getClientIdList() {
		return clientIdList;
	}

	public void setClientIdList(List<Client> clientIdList) {
		this.clientIdList = clientIdList;
	}

	public List<VehicleType> getVehicletypeIdList() {
		return vehicletypeIdList;
	}

	public void setVehicletypeIdList(List<VehicleType> vehicletypeIdList) {
		this.vehicletypeIdList = vehicletypeIdList;
	}


	@Transactional(readOnly = false, rollbackFor = Throwable.class)
	public String delete() {
		if(!Strings.hasValue(getPrimaryId()))
			return INPUT;
		transportationRatesDao.deleteTransportationRate(Long.valueOf(getPrimaryId()));
		return SUCCESS;
	}

	public TransportationRate getTransportationRate() {
		return transportationRate;
	}

	public void setTransportationRate(TransportationRate aTransportationRate) {
		this.transportationRate = aTransportationRate;
	}

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

	@Override
	public String getEntityName() {
		return "TransportationRate";
	}

}
