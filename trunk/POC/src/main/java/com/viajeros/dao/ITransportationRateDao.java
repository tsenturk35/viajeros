package com.viajeros.dao;

import java.util.List;

import com.viajeros.entity.Client;
import com.viajeros.entity.Destination;
import com.viajeros.entity.TransportationRate;
import com.viajeros.entity.VehicleType;

public interface ITransportationRateDao {

	public List<TransportationRate> getAllTransportationRates();

	public void updateTransportationRate(TransportationRate transportationRate);

	public TransportationRate getTransportationRatesById(long anId);

	public void deleteTransportationRate(long anId);

	public List<Client> getClientList();

}
