package com.SpringDemo.Spring1stExample.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.SpringDemo.Spring1stExample.Validator.LoginService;
import com.SpringDemo.Spring1stExample.Models.Player;
import org.springframework.web.client.HttpClientErrorException;

import java.net.http.HttpResponse;

@Controller 

public class LoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object handleUserLogin(ModelMap model, @RequestParam String name,
			@RequestParam String password) {
		Player player;
		if ((player = loginService.validateUser(name, password)) == null) {
			/* Not Tested */
			return new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Invalid Credentials");
		}
		return player;
	}

}