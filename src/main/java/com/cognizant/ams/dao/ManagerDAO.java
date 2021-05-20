package com.cognizant.ams.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ams.modals.Manager;
@Repository
public interface ManagerDAO extends CrudRepository<Manager, Integer>{
	
	public List<Manager> findAll();
	public Manager findByManagerId(int managerId);
	@Query( "FROM Manager where managerId =:username")
	public Manager checkManagerLogin(@Param("username")int managerId);
	@Query( "select managerId FROM Manager where managerId =:username")
	public int getManagerId(@Param("username")int username);

}
