package base.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import base.model.UserModel;
import base.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService service;

	@GetMapping(value = {"/","/home"})
	public String showHome(Model model) {
		UserModel userModel=new UserModel();
		model.addAttribute("userModel", userModel);

		Map<Integer, String> countryMap = service.getAllCountry();
		model.addAttribute("countryMap", countryMap);
		return "home";
	}

	@GetMapping("/getStates")
	@ResponseBody
	public Map<Integer, String> getStateByID(@RequestParam("id")Integer countryID) {
		return service.getStatesByCountryID(countryID);
	}
	@GetMapping("/getCities")
	@ResponseBody
	public Map<Integer, String> getCityByID(@RequestParam("id")Integer stateID) {
		return service.getCityByStateID(stateID);
	}

	@PostMapping("/data")
	public String showData(@ModelAttribute("userModel")UserModel userModel, Model model) {
		Boolean isUserSaved=service.saveUser(userModel);

		if(isUserSaved){
			model.addAttribute("msg", "Hello "+userModel.getFirstName()+" , Registration Almost Done. Please Check your email.");
		}
		else
			model.addAttribute("msg", "SOMETHING WENT WRONG :(");
		return "data";
	}
}
