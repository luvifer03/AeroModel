package com.cognizant.ams.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.ams.dao.PilotDAO;
import com.cognizant.ams.modals.Admin;
import com.cognizant.ams.modals.Hangar;
import com.cognizant.ams.modals.HangarStatus;
import com.cognizant.ams.modals.Manager;
import com.cognizant.ams.modals.Pilot;
import com.cognizant.ams.modals.Plane;
import com.cognizant.ams.service.AdminService;

@Controller
@Validated
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	private PilotDAO pilotDao;

   
	

	@RequestMapping("/LoginAdmin")
	public String loginAdmin(Model model) {
		model.addAttribute("loginBean", new Admin());
		return "loginAdmin";
	}

	@RequestMapping("/CheckLoginAdmin")
	public String checkloginAdmin(@ModelAttribute("loginBean") Admin admin) {

		int check = adminService.checkAdminLogin(admin.getAdminId(), admin.getPassword());
		if (check == 1)
			return "Admin";
		return "failure";

	}

	@RequestMapping("/toaddPlane")
	public String getPlane(Model model) {
		model.addAttribute("plane", new Plane());
		return "AddPlane";
	}

//to add plane details and redirect to success page
	@RequestMapping(value = "/addPlane", method = RequestMethod.POST)
	public String addPlane(@ModelAttribute("plane") Plane plane, Model addPlaneModel) {

		Plane newPlane = adminService.addPlane(plane);

		addPlaneModel.addAttribute("addedPlane", newPlane);
		return "addPlaneSuccess";
	}

//update
//to get plane id from jsp page to update
	@RequestMapping("/toGetPlaneId")
	public String getPlaneId2() {
		return "getPlaneId";
	}

//to display the details of plane for given plane id(update)
	@RequestMapping(value = "/getDetailsOfPlane/{planeId}", method = RequestMethod.GET)
	public String getDetailsByPlaneId(@PathVariable("planeId") int planeId, Model model) {

		Plane plane = adminService.getPlaneDetailsByPlaneId(planeId);
		model.addAttribute("planeDetails", plane);
		return "updatePlaneForm";
	}

	@RequestMapping(value = "/getDetails", method = RequestMethod.GET)
	public String getDetails(@RequestParam("planeId") int planeId, Model model) {

		Plane plane = adminService.getPlaneDetailsByPlaneId(planeId);
		model.addAttribute("planeDetails", plane);
		return "updatePlaneForm";
	}

//to update plane details and redirect to success page
	@RequestMapping(value = "/updatePlane", method = RequestMethod.POST)
	public String updatePlane(@ModelAttribute("planeDetails") Plane plane, Model updatePlaneModel) {

		Plane newPlane = adminService.updatePlane(plane);
		updatePlaneModel.addAttribute("updatedPlane", newPlane);
		return "updatePlaneSuccess";
	}

//view all
//to view list of planes
	@RequestMapping("/viewPlanes")
	public String viewPlanes(Model viewPlanesModel) {
		List<Plane> planes = new ArrayList<Plane>();
		planes = adminService.viewPlanes();

		viewPlanesModel.addAttribute("planesList", planes);
		return "viewPlanesSuccess";
	}

   //to delete plane details and redirect to success page
	@RequestMapping(value = "/deletePlane/{planeId}", method = RequestMethod.GET)
	public String deletePlane(@PathVariable("planeId") int planeId, Model deletePlaneModel) {

		Plane newPilot = adminService.getPlaneDetailsByPlaneId(planeId);

		deletePlaneModel.addAttribute("deletedPlane", newPilot);
		return "deletePlane";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletingPlane(@ModelAttribute("plane") Plane plane, Model deletePlaneModel) {

		Plane newPlane = adminService.deletePlane(plane.getPlaneId());

		deletePlaneModel.addAttribute("deletedPlane", newPlane);
		return "deletePlaneSuccess";
	}

   //add pilot
	@RequestMapping("/toaddPilot")
	public String getPilot(Model model) {
		model.addAttribute("pilot", new Pilot());
		return "AddPilot";
	}

  //to add pilot details and redirect to success page
	@RequestMapping(value = "/addPilot", method = RequestMethod.POST)
	public String addPilot(@ModelAttribute("pilot") Pilot pilot, Model addPilotModel) {
		System.out.println(pilot);
		Pilot newPilot = adminService.addPilot(pilot);
		addPilotModel.addAttribute("addedPilot", newPilot);
		return "AddPilotSuccess";
	}

	// to get pilot id from jsp page to update
	@RequestMapping("/toGetPilotId")
	public String getPilotId() {
		return "getPilotId";
	}

	// to display the details of pilot for given pilot id(update)
	@RequestMapping(value = "/getDetailsOfPilot", method = RequestMethod.POST)
	public String getDetailsByPilotId(@RequestParam("pilotId") int pilotId, Model model) {

		Pilot pilot = adminService.getPilotDetailsByPilotId(pilotId);
		model.addAttribute("pilot", pilot);
		return "UpdatePilot";
	}

	// to display the details of pilot for given pilot id(update)
	@RequestMapping(value = "/getDetailsOfPilot/{pilotId}", method = RequestMethod.GET)
	public String getDetailsByPilotIdByParam(@PathVariable("pilotId") int pilotId, Model model) {

		Pilot pilot = adminService.getPilotDetailsByPilotId(pilotId);
		model.addAttribute("pilot", pilot);
		return "UpdatePilot";
	}

	@RequestMapping(value = "/deleteDetailsOfPilot/{pilotId}", method = RequestMethod.GET)
	public String getDetailsByPilotIdByParamtoDelete(@PathVariable("pilotId") int pilotId, Model model) {

		//Pilot pilot = adminService.getPilotDetailsByPilotId(pilotId);
		pilotDao.deleteById(pilotId);
		//System.out.println(pilot);
		model.addAttribute("message", "deleted successfully");
		return "updatePilotSuccess";
	}

	/*
	 * // to update manager details and redirect to success page
	 * 
	 * @RequestMapping(value = "/deletePilot", method = RequestMethod.POST) public
	 * String deletePilot(@ModelAttribute("pilot") Pilot pilot, Model
	 * updatePilotModel) {
	 * 
	 * Pilot newPilot = adminService.deletePilot(pilot.getPilotId());
	 * 
	 * updatePilotModel.addAttribute("updatedPilot", newPilot); return
	 * "updatePilotSuccess"; }
	 */

	// to update manager details and redirect to success page
	@RequestMapping(value = "/updatePilot", method = RequestMethod.POST)
	public String updatePilot(@ModelAttribute("pilot") Pilot pilot, Model updatePilotModel) {

		Pilot newPilot = adminService.updatePilot(pilot);

		updatePilotModel.addAttribute("updatedPilot", newPilot);
		return "updatePilotSuccess";
	}

	// view all
	// to view list of pilots
	@RequestMapping("/viewPilots")
	public String viewPilots(Model viewPilotsModel) {
		List<Pilot> pilots = new ArrayList<Pilot>();
		pilots = adminService.viewPilots();
		viewPilotsModel.addAttribute("pilotsList", pilots);
		return "/viewPilotsSuccess";
	}

	// to get pilot id from jsp page to update
	@RequestMapping("/planeId")
	public String getPlaneId() {
		return "getPlane";
	}

	@RequestMapping(value = "/getplaneDetails", method = RequestMethod.GET)
	public String getPilotDetailsByPlaneId(@RequestParam("planeId") int planeId, Model model) {
		Pilot pilot = adminService.getPilotDetailsByPlaneId(planeId);
		model.addAttribute("pilotDetails", pilot);
		return "/viewPilotByPlaneId";
	}

	// manager
	// view all
	// to view the list of managers
	@RequestMapping("/viewManagers")
	public String viewManagers(Model viewManagersModel) {
		List<Manager> managers = new ArrayList<Manager>();
		managers = adminService.viewManagers();
		viewManagersModel.addAttribute("managersList", managers);
		return "/viewManagersSuccess";
	}

	@RequestMapping("/toaddHangar")
	public String addHangar(Model model) {
		model.addAttribute("hangar", new Hangar());
		return "/addHangars";
	}

	// to add plane details and redirect to success page
	@RequestMapping(value = "/addHangars", method = RequestMethod.POST)
	public String addingHangar(@Valid @ModelAttribute("addHangars") Hangar hangar) {

		Hangar newHangar = adminService.addHangar(hangar);

		return "/addHangarSuccess";
	}

	@RequestMapping(value = "/addHangarsstatus")
	public String addHangarStatus(Model addHangarModel) {

		addHangarModel.addAttribute("hangarstatus", new HangarStatus());
		return "/hangarStatus";
	}

	@RequestMapping(value = "/addingHangar", method = RequestMethod.POST)
	public String addHangar(@Valid @ModelAttribute("hangarstatus") HangarStatus hangarStatus) {

		HangarStatus newHangar = adminService.addHangarStatus(hangarStatus);

		return "/addHangarStatusSuccess";
	}

	// view all
	// to view list of planes
	@RequestMapping( value = "/viewHangars", method= RequestMethod.GET)
	
	public String viewHangars(Model viewHangarsModel) {
		List<Hangar> hangars = new ArrayList<Hangar>();
		hangars = adminService.viewHangars();
		viewHangarsModel.addAttribute("hangarsList", hangars);
		return "/viewHangarsSuccess";
	}

	// update
	// to get hangar id from jsp page to update
	@RequestMapping("/toGetHangarPlaneId")
	public String getHangarId() {
		return "getHangarId";
	}

	// to display the details of hangar for given hangar id(update)
	@RequestMapping(value = "/getDetailsOfHangar/{hangarId}", method = RequestMethod.GET)
	public String getDetailsByHangarId(@PathVariable("hangarId") int hangarId, Model model) {

		Hangar hangar = adminService.getHangarDetailsByHangarId(hangarId);
		model.addAttribute("hangarDetails", hangar);
		return "updateHangarForm";
	}

	@RequestMapping(value = "/getDetails2", method = RequestMethod.GET)
	public String getDetails2(@RequestParam("hangarId") int hangarId, Model model) {

		Hangar hangar = adminService.getHangarDetailsByHangarId(hangarId);
		model.addAttribute("planeDetails", hangar);
		return "updateHangarForm";
	}

	// to update plane details and redirect to success page
	@RequestMapping(value = "/updateHangar", method = RequestMethod.POST)
	public String updateHangar(@ModelAttribute("hangarDetails") Hangar hangar, Model updateHangarModel) {

		Hangar newHangar = adminService.updateHangar(hangar);
		updateHangarModel.addAttribute("updatedPlane", newHangar);
		return "updateHangarSuccess";
	}

	@RequestMapping(value = "/deleteHangar/{hangarId}", method = RequestMethod.GET)
	public String deleteHangar(@PathVariable("hangarId") int hangarId, Model deleteHangarModel) {
		Hangar newHangar = adminService.getHangarDetailsByHangarId(hangarId);
		deleteHangarModel.addAttribute("hangarDetails", newHangar);
		return "deleteHangar";
	}

	@RequestMapping(value = "/delete2", method = RequestMethod.POST)
	public String deletingHangar(@ModelAttribute("hangar") Hangar hangar, Model deleteHangarModel) {

		Hangar newHangar = adminService.deleteHangar(hangar.getHangarId());

		deleteHangarModel.addAttribute("deletedHangar", newHangar);
		return "deletePlaneSuccess";
	}

	// to delete manager details and redirect to success page
	@RequestMapping(value = "/deleteManager/{managerId}", method = RequestMethod.GET)
	public String deleteManager(@PathVariable("managerId") int managerId, Model deleteManagerModel) {

		Manager newManager = adminService.deleteManager(managerId);

		// deleteManagerModel.addAttribute("deletedManager", newManager);
		return "/deleteManagerSuccess";
	}

	@RequestMapping("/accept")
	public String acceptManager() {
		return "accept";
	}

	@RequestMapping(value = "/addHangarStatus", method = RequestMethod.POST)
	public String addHangarStatus(@ModelAttribute("status") HangarStatus hangarStatus, Model addHangarStatus) {

		HangarStatus newHangarStatus = adminService.addHangarStatus(hangarStatus);

		addHangarStatus.addAttribute("addedPilot", newHangarStatus);
		return "AddPilotSuccess";
	}

	@RequestMapping("/Admin")
	public String getAdmin() {
		return "Admin";
	}

}
