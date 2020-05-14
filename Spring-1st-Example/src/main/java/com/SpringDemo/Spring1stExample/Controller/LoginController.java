package com.SpringDemo.Spring1stExample.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.SpringDemo.Spring1stExample.Validator.LoginService;
import com.SpringDemo.Spring1stExample.Models.Player;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

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
	public Player handleUserLogin(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value="password", required= true) String password) {
		Player player;
		if ((player = loginService.validateUser(name, password)) == null) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "The Credentials you specified were invalid.");
		}
		return player;
	}

}