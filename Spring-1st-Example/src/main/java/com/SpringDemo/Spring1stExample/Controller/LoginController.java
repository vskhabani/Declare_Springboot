package com.SpringDemo.Spring1stExample.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringDemo.Spring1stExample.Validator.LoginService;
import com.SpringDemo.Spring1stExample.Models.Player;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;

	@GetMapping(value="/login")
	public Player getPlayer(@RequestParam(value="playerId", required = true) int playerId){
		Player player;
		if((player = loginService.getPlayer(playerId)) != null){
			return player;
		}
		throw new  Resp
	}

	@PostMapping(value = "/login")
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