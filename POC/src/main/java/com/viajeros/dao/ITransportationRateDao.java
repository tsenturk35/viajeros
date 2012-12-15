package com.viajeros.dao;

import java.util.List;

import com.viajeros.entity.Destination;
import com.viajeros.entity.TransportationRate;

public interface ITransportationRateDao {

	public List<TransportationRate> getAllTransportationRates();
	public List<Destination> getAllSourceId();

	void updateTransportationRate(TransportationRate transportationRate);
	public TransportationRate listTransportationRatesById(long anId);
	public void deleteTransportationRate(long anId);




}
