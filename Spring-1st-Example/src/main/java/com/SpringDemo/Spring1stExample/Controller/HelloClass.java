package com.SpringDemo.Spring1stExample.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringDemo.Spring1stExample.Validator.LoginService;

@Controller 

public class HelloClass {
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model, @RequestParam String mail,
			@RequestParam String password , @RequestParam String password1 ,@RequestParam String fname,@RequestParam String lname) {

		if (!loginService.validateMail(mail)) {
			model.put("errorMessage", "Please Enter Valid Email");
			return "login";
		}
		else if (!loginService.validatePassword(password, password1))
		{
			model.put("errorMessage", "Passwords Do not match !!!!  ");
			return "login";
		}
		else{
		model.put("mail", mail);
		model.put("first_name", fname);
		model.put("last_name", lname);
		
		return "welcome";
		}
	}

}