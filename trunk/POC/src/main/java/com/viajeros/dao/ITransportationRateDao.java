package com.viajeros.dao;

import java.util.List;

import com.viajeros.entity.TransportationRate;

public interface ITransportationRateDao {

	public List<TransportationRate> getAllTransportationRates();

	public void updateTransportationRate(TransportationRate transportationRate);

	public TransportationRate getTransportationRatesById(long anId);

	public void deleteTransportationRate(long anId);


}
