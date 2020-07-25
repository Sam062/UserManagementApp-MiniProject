package base.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import base.model.UserModel;

@Controller
public class UserController {
	
	@GetMapping(value = {"/","/home"})
	public String showHome(Model model) {
		
		List<String> countryList=List.of("INDIA","USA","AMARICA");
		List<String> stateList=List.of("INDIA","USA","AMARICA");
		List<String> cityList=List.of("INDIA","USA","AMARICA");
		UserModel userModel=new UserModel();

		model.addAttribute("countryList", countryList);
		model.addAttribute("stateList", stateList);
		model.addAttribute("cityList", cityList);
		model.addAttribute("userModel", userModel);
		return "home";
	}

	@PostMapping("/data")
	public String showData(@ModelAttribute("userModel")UserModel userModel, RedirectAttributes attribute) {
		//
		//		Boolean isUserSaved=service.saveUser(userModel);
		//
		//		if(!isUserSaved){
		//			attribute.addFlashAttribute("msg", "User Details Couldn't Add.");
		//		}else {
		//			attribute.addFlashAttribute("msg", "User Details Added.");
		//		}
		attribute.addFlashAttribute("msg", userModel);
		return "redirect:/home";
	}

}
