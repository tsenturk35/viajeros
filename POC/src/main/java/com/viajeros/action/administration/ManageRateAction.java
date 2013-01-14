package com.viajeros.action.administration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.viajeros.dao.IDestinationDao;
import com.viajeros.dao.IDetentionRateDao;
import com.viajeros.dao.IVehicleTypeDao;
import com.viajeros.entity.Client;
import com.viajeros.entity.Destination;
import com.viajeros.entity.DetentionRate;
import com.viajeros.entity.VehicleType;
import com.viajeros.utils.Strings;

public class ManageRateAction extends AbstractAdminAction {

	public ManageRateAction() {
		super();
	}

	private static final long serialVersionUID = -4148283833746131990L;

	private DetentionRate detentionRate = new DetentionRate();
	private List<DetentionRate> detentionRateList = new ArrayList<DetentionRate>();

	private List<Destination> destinationIdList;
	private List<Client> clientIdList;
	private List<VehicleType> vehicletypeIdList;

	@Autowired
	private IDetentionRateDao detentionRatesDao;
	@Autowired
	private IVehicleTypeDao vehicleTypeDao;
	@Autowired
	private IDestinationDao destinationDao;

	@Transactional(readOnly = true)
	public String list() {
		detentionRateList = detentionRatesDao.getAllDetentionRates();
		return SUCCESS;

	}

	@Transactional(readOnly = true)
	public String view() {
		destinationIdList = destinationDao.getDestinationList();
		clientIdList = detentionRatesDao.getClientList();
		vehicletypeIdList = vehicleTypeDao.getVehicleTypeList();
		if (!Strings.hasValue(getPrimaryId()))
			return INPUT;
		detentionRate = detentionRatesDao.getDetentionRatesById(Long
				.valueOf(getPrimaryId()));
		if (null == detentionRate)
			addActionError("Error: Detention Rate not found!");
		return INPUT;
	}

	@Transactional(readOnly = false, rollbackFor = Throwable.class)
	public String save() {
		detentionRatesDao.updateDetentionRate(detentionRate);
		detentionRateList = detentionRatesDao.getAllDetentionRates();
		addActionMessage("Detention Rate saved successfully.");
		return SUCCESS;
	}

	@Transactional(readOnly = false, rollbackFor = Throwable.class)
	public String delete() {
		if (!Strings.hasValue(getPrimaryId()))
			return INPUT;
		detentionRatesDao.deleteDetentionRate(Long.valueOf(getPrimaryId()));
		return SUCCESS;
	}

	public DetentionRate getDetentionRate() {
		return detentionRate;
	}

	public void setDetentionRate(DetentionRate detentionRate) {
		this.detentionRate = detentionRate;
	}

	public List<DetentionRate> getDetentionRateList() {
		return detentionRateList;
	}

	public void setDetentionRateList(List<DetentionRate> detentionRateList) {
		this.detentionRateList = detentionRateList;
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

	public IDetentionRateDao getDetentionRatesDao() {
		return detentionRatesDao;
	}

	public void setDetentionRatesDao(IDetentionRateDao detentionRatesDao) {
		this.detentionRatesDao = detentionRatesDao;
	}

	@Override
	public String getEntityName() {
		return "DetentionRate";
	}

}
