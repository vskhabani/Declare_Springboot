package declare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import declare.Models.Auth;
import declare.Models.Player;
import declare.Services.AuthService;
import declare.Services.PlayerService;

@RestController
public class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	private PlayerService playerService;

	@GetMapping(value = "/auth")
	public Auth get(@RequestParam(value = "token", required = true) String token) {
		Auth auth;
		if ((auth = authService.validateToken(token)) != null) {
			return auth;
		}
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid Token");
	}

	@PostMapping(value = "/auth")
	@ResponseBody
	public Player post(@RequestBody Player player) {

//		return playerService.create(email, firstName, lastName, username, null);
		return playerService.create(player);
//		Auth auth;
//		if ((auth = authService.create(token, player.getPlayerId())) != null) {
//			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Something went wrong. Unable to create an account");
//		}
//		return auth;
	}

}