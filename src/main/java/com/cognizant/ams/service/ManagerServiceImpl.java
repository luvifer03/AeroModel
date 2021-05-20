package com.cognizant.ams.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ams.dao.HangarDAO;
import com.cognizant.ams.dao.HangarStatusDAO;
import com.cognizant.ams.dao.ManagerDAO;
import com.cognizant.ams.dao.PlaneDAO;
import com.cognizant.ams.modals.Admin;
import com.cognizant.ams.modals.Hangar;
import com.cognizant.ams.modals.HangarStatus;
import com.cognizant.ams.modals.Manager;
import com.cognizant.ams.modals.Plane;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerDAO managerDAO;
	@Autowired
	PlaneDAO planeDAO;
	@Autowired
	HangarStatusDAO hangarStatusDAO;
	@Autowired
	HangarDAO hangarDAO;

	@Override
	@Transactional
	public List<Plane> viewPlanes() {
		return this.planeDAO.viewAvailablePlanes(0);
	}

	@Override
	@Transactional
	public List<HangarStatus> viewHangarStatus(int managerId) {
		return this.hangarStatusDAO.viewAvailableHangars(managerId, "A");
	}

	@Override
	@Transactional
	public int allotHangartoPlane(int planeId, int hangarId) {
		return this.planeDAO.allotHangartoPlane(planeId, hangarId);
	}

	@Override
	@Transactional
	public int allotPlanetoHangar(int planeId, int hangarId) {
		return this.hangarDAO.allotPlanetoHangar(planeId, hangarId);
	}

	@Override
	@Transactional
	public Manager addManager(Manager manager) {
		return this.managerDAO.save(manager);

	}

	@Override
	@Transactional
	public int checkManagerLogin(int username, String password) {
		Manager manager = this.managerDAO.checkManagerLogin(username);
		if (manager != null) {
			if (manager.getManagerId() == (username) && manager.getPassword().equals(password)) {
				return 1;
			}
		}
		return 0;

	}

	@Override
	@Transactional
	public int getManagerId(int username) {
		return this.managerDAO.getManagerId(username);
	}

	@Override
	@Transactional
	public HangarStatus hangarStatus(int hangarId) {
		return this.hangarStatusDAO.findByHangarId(hangarId);

	}

	@Override
	@Transactional
	public HangarStatus updateHangar(HangarStatus hangarStatus) {

		return this.hangarStatusDAO.save(hangarStatus);
	}

	@Override
	public List<Plane> findAll() {
		return this.planeDAO.findAll();
	}
	/*
	 * @Override @Transactional public Plane allotHangar(Plane plane, Hangar hangar)
	 * { return this.planeDAO.allotHangar(plane,hangar); }
	 */

}
