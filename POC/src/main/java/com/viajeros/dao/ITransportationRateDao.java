package com.viajeros.dao;

import java.util.List;

import com.viajeros.entity.Client;
import com.viajeros.entity.Destination;
import com.viajeros.entity.TransportationRate;
import com.viajeros.entity.VehicleType;

public interface ITransportationRateDao {

	public List<TransportationRate> getAllTransportationRates();

	public List<String> getAllSourceId();

	void updateTransportationRate(TransportationRate transportationRate);

	public TransportationRate listTransportationRatesById(long anId);

	public void deleteTransportationRate(long anId);

	public List<String> getAlldestinationIdList();

	public List<String> getAllClientIdList();

	public List<String> getAllVehicleTypeIdList();

}
