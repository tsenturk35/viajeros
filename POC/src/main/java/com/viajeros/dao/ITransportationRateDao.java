package com.viajeros.dao;

import java.util.List;

import com.viajeros.entity.Client;
import com.viajeros.entity.Destination;
import com.viajeros.entity.TransportationRate;
import com.viajeros.entity.VehicleType;

public interface ITransportationRateDao {

	public List<TransportationRate> getAllTransportationRates();

	public List<Destination> getAllSourceId();

	void updateTransportationRate(TransportationRate transportationRate);

	public TransportationRate listTransportationRatesById(long anId);

	public void deleteTransportationRate(long anId);

	public List<Destination> getAlldestinationIdList();

	public List<Client> getAllClientIdList();

	public List<VehicleType> getAllVehicleTypeIdList();

}
