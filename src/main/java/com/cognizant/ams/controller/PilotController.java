package com.cognizant.ams.controller;
/*
 * package com.ams.controller;
 * 
 * import javax.validation.Valid;
 * 
 * import org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod;
 * 
 * import com.ams.modals.Manager; import com.ams.modals.Pilot; import
 * com.ams.service.PilotService;
 * 
 * public class PilotController {
 * 
 * @RequestMapping("/toregistermanager") public String display(Model model) {
 * model.addAttribute("manager",new Manager()); return "/registerManagerForm"; }
 * 
 * @RequestMapping(value="/registermanager",method=RequestMethod.POST) public
 * String addManager(@Valid @ModelAttribute("admin")Manager manager,Model
 * managerModel) { Pilot newPilot= PilotService.addPilot(pilot);
 * pilotModel.addAttribute("addedPilot",newPilot); return
 * "/registerManagerSuccess"; }
 * 
 * @RequestMapping("/tologinpilot") public String login(Model model) {
 * model.addAttribute("pilot", new Pilot()); return "/pilotLogin"; }
 * 
 * @RequestMapping("/loginpilot") public String login(@ModelAttribute("manager")
 * Manager manager,Model m) { int username = manager.getManagerId(); String
 * password = manager.getPassword(); m.addAttribute("Id",username);
 * if(PilotService.checkPilotLogin(username, password)==1) return
 * "/viewPilotForm"; else return "failure"; }
 * 
 * 
 * }
 */