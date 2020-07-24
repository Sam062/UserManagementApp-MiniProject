package base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import base.model.UserModel;

@Controller
public class UserController {

	@GetMapping(value = {"/","/home"})
	public String showHome(Model model) {
		UserModel userModel=new UserModel();

		model.addAttribute("userModel", userModel);
		return "home";
	}
	@PostMapping("/data")
	public String showData(@ModelAttribute("userModel")UserModel userModel, Model model) {
		model.addAttribute("msg", userModel);
		return "data";
	}

}
