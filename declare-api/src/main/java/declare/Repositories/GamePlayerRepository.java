package declare.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import declare.Models.GamePlayer;

@Repository
public interface GamePlayerRepository extends JpaRepository<GamePlayer, Integer> {

	List<GamePlayer> findByGameId(int gameId);

	GamePlayer findByGameIdAndPlayerId(int gameId, int playerId);

	GamePlayer getOne(int gamePlayerId);

}