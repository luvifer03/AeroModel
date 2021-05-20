package com.cognizant.ams.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ams.modals.Hangar;
@Repository
public interface HangarDAO extends CrudRepository<Hangar, Integer> {
	public Hangar findByHangarId(int hangarId);
	public List<Hangar> findAll();
	@Query( "FROM Hangar where planeId =:planeId")
	public Hangar findHangarDetailsByPlaneId(@Param("planeId")int planeId);
	@Modifying
	@Query( "update Hangar set planeId =:planeId where hangarId =:hangarId")
	public int allotPlanetoHangar(@Param("planeId")int planeId, @Param("hangarId")int hangarId);
}
