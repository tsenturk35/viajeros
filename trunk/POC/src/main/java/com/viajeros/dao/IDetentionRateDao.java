package com.viajeros.dao;

import java.util.List;

import com.viajeros.entity.Client;
import com.viajeros.entity.DetentionRate;

public interface IDetentionRateDao {

	public List<DetentionRate> getAllDetentionRates();

	public void updateDetentionRate(DetentionRate detentionRate);

	public DetentionRate getDetentionRatesById(long anId);

	public void deleteDetentionRate(long anId);

	public List<Client> getClientList();
}
