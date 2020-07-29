package base.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import base.entity.CityMaster;
import base.entity.CountryMaster;
import base.entity.StateMaster;
import base.model.UserModel;
import base.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService service;

	@GetMapping(value = {"/","/home"})
	public String showHome(Model model) {

		List<CountryMaster> countryList=service.getAllCountry();
		List<StateMaster> stateList=service.getAllState();
		List<CityMaster> cityList=service.getAllCity();
		UserModel userModel=new UserModel();

		model.addAttribute("countryList", countryList);
		model.addAttribute("stateList", stateList);
		model.addAttribute("cityList", cityList);
		model.addAttribute("userModel", userModel);
		return "home";
	}

	@PostMapping("/data")
	public String showData(@ModelAttribute("userModel")UserModel userModel, RedirectAttributes attribute) {
		Boolean isUserSaved=service.saveUser(userModel);

		if(isUserSaved){
			attribute.addFlashAttribute("msg", "User Details Added.");
		}
		else
			attribute.addFlashAttribute("msg", "User Details Couldn't Add.");
		System.out.println(userModel);
		return "redirect:/home";
	}

}
