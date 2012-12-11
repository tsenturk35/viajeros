package com.viajeros.dao;

import java.util.List;

import com.viajeros.entity.TransportationRate;

public interface ITransportationRateDao {

	public List<TransportationRate> getAllTransportationRates();

	void updateTransportationRate(TransportationRate transportationRate);




}
