package com.viajeros.dao;

import java.util.List;

import com.viajeros.entity.Destination;
import com.viajeros.exception.UpdateException;

public interface IDestinationDao {
	
	public List<Destination> getDestinationList();

	public Destination saveDestination(Destination destination);

	public Destination getDestinationById(Long id);

	public void deleteDestination(Long valueOf) throws UpdateException;

}
