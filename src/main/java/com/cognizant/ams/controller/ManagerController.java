package com.cognizant.ams.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.ams.dao.ManagerDAO;
import com.cognizant.ams.modals.Admin;
import com.cognizant.ams.modals.Hangar;
import com.cognizant.ams.modals.HangarStatus;
import com.cognizant.ams.modals.Manager;
import com.cognizant.ams.modals.Plane;
import com.cognizant.ams.service.AdminService;
import com.cognizant.ams.service.ManagerService;


@Controller
public class ManagerController {


	@Autowired
	ManagerService managerService;
	
		@RequestMapping("/toRegisterManager")
	    public String display(Model model)
	    {
			model.addAttribute("manager",new Manager());
			return "/registerManagerForm";
	    }
		
		@RequestMapping(value="/registerManager",method=RequestMethod.POST)
		public String addManager(@Valid @ModelAttribute("admin")Manager manager,Model managerModel)
		{
		    Manager newManager= managerService.addManager(manager);
			managerModel.addAttribute("addedManager",newManager);
			managerModel.addAttribute("message",manager.getManagerId());
			return "/registerManagerSuccess";
		}
		
		@RequestMapping("/toLoginManager")
		public String login(Model model) {
			model.addAttribute("manager", new Manager());
			return "/managerLogin";
		}

		@RequestMapping("/loginManager")
		public String login(@ModelAttribute("manager") Manager manager,Model m) {
			int username = manager.getManagerId();
			String password = manager.getPassword();
			m.addAttribute("Id",username);
			if(managerService.checkManagerLogin(username, password)==1)
			return "/viewManagerForm";
			else
				return "failure";
		}
		

		@RequestMapping("/ViewPlaneStatus")
		public String viewPlanes(Model model) {
			System.out.println("------ Inside viewPlanes() method ---------");
			List<Plane> plane = new ArrayList<Plane>();
			plane= managerService.findAll();
			model.addAttribute("plane", plane);
			return "/viewPlanes";
		}
		
		@RequestMapping("/ViewHangarStatus/{Id}")
		public String viewHangarStatus(@PathVariable("Id")int username,Model model) {
			System.out.println("------ Inside viewPlanes() method ---------");
			List<HangarStatus> hangarStatus = new ArrayList<HangarStatus>();
			int managerId=managerService.getManagerId(username);
			System.out.println(managerId);
			hangarStatus= managerService.viewHangarStatus(managerId);
			model.addAttribute("hangarStatus",hangarStatus);
			return "/viewHangarStatus";
		}
		
		@RequestMapping("/HangarAllotment")
		public String allotHangar(Model model)
		{  
			model.addAttribute("plane",new Plane());
			model.addAttribute("hangarStatus",new HangarStatus());
			return "/allotHangar";
			
		}
		
		@RequestMapping("/afterAllotHangar")
		public String afterAllotHangaer(@RequestParam("planeId")int planeId,@RequestParam("hangarId")int hangarId,Model model)
		{
			int plane=managerService.allotHangartoPlane(planeId, hangarId);
			int hangar=managerService.allotPlanetoHangar(planeId, hangarId);
			HangarStatus hangarStatus=null;
			
			hangarStatus=managerService.hangarStatus(hangarId);
		    
			model.addAttribute("plane", plane);
			model.addAttribute("hangarStatus", hangarStatus);
			return "/afterAllotHangar";
			
		}
		
		//to update plane details and redirect to success page
		@RequestMapping(value="/updateHangarStatus",method=RequestMethod.POST)
		public String updatePlane(@ModelAttribute("hangarStatus")HangarStatus hangarStatus,Model hangarStatusModel )
		{

		  HangarStatus newStatus=managerService.updateHangar(hangarStatus);
		  hangarStatusModel.addAttribute("updatedHangarStatus",newStatus);
	      return "updateHangarSuccess";
		}
	
}
