package com.SpringDemo.Spring1stExample.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringDemo.Spring1stExample.Validator.LoginService;
@Controller
public class SignupController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String showLoginPage() {
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model, @RequestParam String mail,
			@RequestParam String password , @RequestParam String password1 ,@RequestParam String fname,@RequestParam String lname) {

		if (!loginService.validateMail(mail)) {
			model.put("errorMessage", "Please Enter Valid Email");
			return "signup";
		}
		else if (!loginService.validatePassword(password, password1))
		{
			model.put("errorMessage", "Passwords Do not match !!!!  ");
			return "signup";
		}
		else{
		model.put("mail", mail);
		model.put("first_name", fname);
		model.put("last_name", lname);
		
		return "welcome";
		}

}}
