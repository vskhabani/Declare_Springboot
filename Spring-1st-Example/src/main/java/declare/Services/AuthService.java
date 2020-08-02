package declare.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import declare.Models.Auth;
import declare.Repositories.AuthRepository;

@Service
public class AuthService {

	@Autowired
	private AuthRepository authRepository;

	public Auth validateToken(String token) {
		Assert.hasLength(token, "Missing token");
		return authRepository.findByToken(token);
	}

	public Auth create(String token, int playerId) {
		Assert.hasLength(token, "Missing Token");
		Assert.notNull(playerId, "Missing Player Id"); // TODO: Update to use Validator
		Auth auth = new Auth(token, playerId);
		authRepository.saveAndFlush(auth);
		return auth;
	}

}
