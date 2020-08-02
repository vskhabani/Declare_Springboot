package declare.Services;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import declare.Models.Player;
import declare.Repositories.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	public Player validateUser(String user, String password) {
		return playerRepository.findByUsernameAndPassword(user, password);
	}

	public Player getPlayer(int playerId) {
		return playerRepository.getOne(playerId);
	}

	public Player create(Player player) {
		player.setSignupDate(new Timestamp(System.currentTimeMillis()));
		return playerRepository.saveAndFlush(player);
	}

	public Player create(String email, String firstName, String lastName, String username, String password) {
		Player newPlayer = new Player(email, firstName, lastName, username, password);
		return playerRepository.saveAndFlush(newPlayer);
	}

}
