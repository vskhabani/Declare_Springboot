package declare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import declare.Models.Player;
import declare.Services.PlayerService;

@RestController
public class LoginController {
	@Autowired
	private PlayerService playerService;

	@GetMapping(value = "/login")
	public Player getPlayer(@RequestParam(value = "playerId", required = true) int playerId) {
		Player player;
		if ((player = playerService.getPlayer(playerId)) != null) {
			return player;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found");
	}

	@PostMapping(value = "/login")
	@ResponseBody
	public Player handleUserLogin(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "password", required = true) String password) {
		Player player;
		if ((player = playerService.validateUser(name, password)) == null) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "The Credentials you specified were invalid.");
		}
		return player;
	}

}