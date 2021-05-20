package com.cognizant.ams.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ams.modals.Admin;


@Repository
public interface AdminDAO extends CrudRepository<Admin, Integer> {
	public List<Admin> findAll();
	@Query( "FROM Admin where adminId =:username")
	public Admin checkAdminLogin(@Param("username")int username);
}