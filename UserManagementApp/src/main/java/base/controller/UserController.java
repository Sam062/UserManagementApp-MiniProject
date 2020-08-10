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

import base.config.TwilloMsg;
import base.model.UserModel;
import base.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService service;

	@GetMapping(value = {"/","/start"})
	public String startPage(Model model) {
		UserModel userModel=new UserModel();
		model.addAttribute("userModel", userModel);
		return "startPage";
	}

	@PostMapping(value = "/validate")
	public String validateLogin(@ModelAttribute("userModel")UserModel userModel, Model model) {
		UserModel result = service.findByEmailAndPassword(userModel.getEmail(), userModel.getPassword());
		if(result!=null)
			return "dashboard";
		else {
			model.addAttribute("msg", "Invalid Credentials.");
			return "startPage";
		}
	}
	@GetMapping("/forgotPwd")
	public String forgotPwd(Model model) {
		UserModel userModel=new UserModel();
		model.addAttribute("userModel", userModel);
		return "forgotPwd";
	}
	@PostMapping("/recoverPwd")
	public String recoverPwd(@ModelAttribute("userModel")UserModel userModel,Model model) {
		UserModel result = service.findByUserEmail(userModel.getEmail());
		if(result!=null) {
			if(result.getAccountStatus().equals("LOCKED"))
				model.addAttribute("msg", "Please UNLOCK your account first.");
			else{
				TwilloMsg.sendMsg(result.getPhoneNo(), "Your UMT Password is : "+result.getPassword());
				return "startPage";
			}
		}
		else
			model.addAttribute("msg", "Invalid Email.");

		return "forgotPwd";
	}

	@GetMapping(value = {"/home"})
	public String showHome(Model model) {
		UserModel userModel=new UserModel();
		model.addAttribute("userModel", userModel);

		Map<Integer, String> countryMap = service.getAllCountry();
		model.addAttribute("countryMap", countryMap);
		return "home";
	}

	@GetMapping("/validateEmail")
	public @ResponseBody String emailValidater(@RequestParam("email")String email) {
		UserModel model=service.findByUserEmail(email);
		if(model!=null)
			return "duplicate";
		else
			return "unique";
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
			model.addAttribute("msg", "Hello "+userModel.getFirstName()+" , <br/>Thank you for registering here, Registration almost done. Please check your email.");
		}
		else
			model.addAttribute("msg", "SOMETHING WENT WRONG :(");
		return "data";
	}
}
