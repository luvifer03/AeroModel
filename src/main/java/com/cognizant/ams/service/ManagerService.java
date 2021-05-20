package com.cognizant.ams.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.ams.modals.Hangar;
import com.cognizant.ams.modals.HangarStatus;
import com.cognizant.ams.modals.Manager;
import com.cognizant.ams.modals.Plane;
@Service
public interface ManagerService{
	
	public List<Plane> viewPlanes();
	public List<HangarStatus> viewHangarStatus(int managerId);
	public int allotHangartoPlane(int planeId,int hangarId);
	public int allotPlanetoHangar(int planeId,int hangarId);
	public Manager addManager(Manager manager);
	public int checkManagerLogin(int username, String password);
	public int getManagerId(int username);
	public HangarStatus hangarStatus(int hangarId);
	public HangarStatus  updateHangar(HangarStatus hangarStatus);
	public List<Plane> findAll();
}
