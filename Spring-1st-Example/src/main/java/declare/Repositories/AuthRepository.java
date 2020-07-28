package declare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import declare.Models.Auth;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Integer> {

	Auth findByPlayerId(int playerId);

	Auth findByToken(String token);

	Auth getOne(int authId);

}