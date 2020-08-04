package base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import base.model.UnlockAccount;
import base.model.UserModel;
import base.service.IUserService;

@Controller
public class UserUnlockController {

	@Autowired
	private IUserService service;

	@GetMapping("/unlockAcc")
	public String unlockAccount(@RequestParam("email")String email, Model model) {
		UnlockAccount unlockAccount=new UnlockAccount();
		unlockAccount.setEmail(email);
		model.addAttribute("unlockAccount", unlockAccount);

		return "unlockAcc";
	}

	@PostMapping("/unlockUserAccount")
	public String unlockAccount(@ModelAttribute("unlockAccount")UnlockAccount unlockAccount, Model model) {
		UserModel account=service.findByEmailAndPassword(unlockAccount.getEmail(),unlockAccount.getTempPwd());
		if(account!=null) {
			service.updateUserAccount(unlockAccount);
			return "unlockAccountSuccess";	
		}
		else{
			model.addAttribute("msg","Incorrect Email or Temporary Password!");
			return "unlockAcc";
		}
	}

}
