package com.cognizant.ams.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ams.modals.Pilot;
@Repository
public interface PilotDAO extends CrudRepository<Pilot, Integer> {
	
	
	public Pilot findByPilotId(int pilotId);
	public List<Pilot> findAll();
	@Query( "FROM Pilot where planeId =:planeId")
	public Pilot findPilotDetailsByPlaneId(@Param("planeId")int planeId);

	
}
