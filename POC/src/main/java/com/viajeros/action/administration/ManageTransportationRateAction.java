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
import com.viajeros.entity.Client;
import com.viajeros.entity.Destination;
import com.viajeros.entity.TransportationRate;
import com.viajeros.entity.VehicleType;

public class ManageTransportationRateAction extends AbstractAdminAction {

	public ManageTransportationRateAction() {
		super();
	}

	private static final long serialVersionUID = -6659925652584240539L;

	private TransportationRate transportationRate = new TransportationRate();
	private List<TransportationRate> transportationRateList = new ArrayList<TransportationRate>();
	private List<Destination> sourceIdList;
	private List<Destination> destinationIdList;
	private List<Client> clientIdList;
	private List<VehicleType> vehicletypeIdList;
	private long transportationRateId;

	public long getTransportationRateId() {
		return transportationRateId;
	}

	public void setTransportationRateId(long transportationRateId) {
		this.transportationRateId = transportationRateId;
	}

	@Autowired
	private ITransportationRateDao transportationRatesDao;


	@Transactional(readOnly = false, rollbackFor = Throwable.class)
	public String save() {
		transportationRatesDao.updateTransportationRate(transportationRate);
		transportationRateList = transportationRatesDao.getAllTransportationRates();
		return SUCCESS;
	}

	@Transactional(readOnly = true)
	public String view() {
		sourceIdList = transportationRatesDao.getAllSourceId();
		destinationIdList = transportationRatesDao.getAlldestinationIdList();
		clientIdList = transportationRatesDao.getAllClientIdList();
		vehicletypeIdList = transportationRatesDao.getAllVehicleTypeIdList();

		return INPUT;
	}

	@Transactional(readOnly = true)
	public String list() {
		transportationRateList = transportationRatesDao
				.getAllTransportationRates();
		return SUCCESS;
	}

//	@Transactional(readOnly = true)
//	public String sourceIdList() {
//		sourceIdList = transportationRatesDao.getAllSourceId();
//		return SUCCESS;
//	}
//
//	@Transactional(readOnly = true)
//	public String destinationIdList() {
//		destinationIdList = transportationRatesDao.getAlldestinationIdList();
//		return SUCCESS;
//	}
//
//	@Transactional(readOnly = true)
//	public String clientIdList() {
//		clientIdList = transportationRatesDao.getAllClientIdList();
//		return SUCCESS;
//	}

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

//	@Transactional(readOnly = true)
//	public String vehicleTypeIdList() {
//		vehicletypeIdList = transportationRatesDao.getAllVehicleTypeIdList();
//		return SUCCESS;
//	}

	public List<Destination> getSourceIdList() {
		return sourceIdList;
	}

	public void setSourceIdList(List<Destination> sourceIdList) {
		this.sourceIdList = sourceIdList;
	}

	@Transactional(readOnly = false, rollbackFor = Throwable.class)
	public String delete() {
		transportationRatesDao
				.deleteTransportationRate(getTransportationRateId());
		return SUCCESS;
	}

//	@Transactional(readOnly = false, rollbackFor = Throwable.class)
//	public String edit() {
//		transportationRate = transportationRatesDao
//				.listTransportationRatesById(getTransportationRateId());
//		return SUCCESS;
//	}

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
