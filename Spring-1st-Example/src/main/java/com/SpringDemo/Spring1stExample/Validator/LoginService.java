package com.SpringDemo.Spring1stExample.Validator;

import com.SpringDemo.Spring1stExample.Models.PlayerRepository;
import com.SpringDemo.Spring1stExample.Models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	private PlayerRepository playerRepository;

	public Player validateUser(String user, String password) {
		return playerRepository.findByUsernameAndPassword(user, password);
	}
}
