package com.viajeros.action.administration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.viajeros.dao.IVehicleTypeDao;
import com.viajeros.entity.VehicleType;
import com.viajeros.utils.Strings;

public class ManageVehicleTypeAction extends AbstractAdminAction {

	public ManageVehicleTypeAction() {
		super();
	}

	private static final long serialVersionUID = -7216747552314320216L;
	private VehicleType vehicleType = new VehicleType();
	private List<VehicleType> vehicleTypeList = new ArrayList<VehicleType>();
	private long vehicleTypeId;

	@Autowired
	private IVehicleTypeDao vehicleTypeDao;

	public IVehicleTypeDao getVehicleTypeDao() {
		return vehicleTypeDao;
	}

	public void setVehicleTypeDao(IVehicleTypeDao vehicleTypeDao) {
		this.vehicleTypeDao = vehicleTypeDao;
	}

	@Transactional(readOnly = false, rollbackFor = Throwable.class)
	public String save() {
		vehicleTypeDao.updateVehicleType(vehicleType);
		vehicleTypeList = vehicleTypeDao.getVehicleTypeList();
		addActionMessage("Vehicle Type saved successfully.");
		return SUCCESS;
	}

	@Transactional(readOnly = true)
	public String view() {
		if (!Strings.hasValue(getPrimaryId()))
			return INPUT;
		vehicleType = vehicleTypeDao.getVehicleTypeById(Long
				.valueOf(getPrimaryId()));

		if (null == vehicleType)
			addActionError("Error: Vehicle Type not found!");
		return INPUT;
	}

	@Transactional(readOnly = true)
	public String list() {
		vehicleTypeList = vehicleTypeDao.getVehicleTypeList();
		return SUCCESS;
	}

	@Transactional(readOnly = false, rollbackFor = Throwable.class)
	public String delete() {
		if (!Strings.hasValue(getPrimaryId()))
			return INPUT;
		vehicleTypeDao.deleteVehicleType(Long.valueOf(getPrimaryId()));

		vehicleTypeList = vehicleTypeDao.getVehicleTypeList();
		addActionMessage("Vehicle Type deleted successfully");

		return SUCCESS;
	}

	// @Transactional(readOnly = false, rollbackFor = Throwable.class)
	// public String edit() {
	// vehicleType = vehicleTypeDao.listVehicleTypeById(getVehicleTypeId());
	// return SUCCESS;
	// }

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public List<VehicleType> getVehicleTypeList() {
		return vehicleTypeList;
	}

	public void setVehicleTypeList(List<VehicleType> vehicleTypeList) {
		this.vehicleTypeList = vehicleTypeList;
	}

	public long getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(long vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	@Override
	public String getEntityName() {
		return "VehicleType";
	}

}
