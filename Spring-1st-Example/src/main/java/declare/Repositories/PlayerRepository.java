package declare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import declare.Models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	Player findByUsernameAndPassword(String username, String password);

	Player getOne(int playerId);

}