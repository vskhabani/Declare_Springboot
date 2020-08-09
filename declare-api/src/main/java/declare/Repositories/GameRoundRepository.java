package declare.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import declare.Models.GameRound;

@Repository
public interface GameRoundRepository extends JpaRepository<GameRound, Integer> {

	List<GameRound> findByGameId(int gameId);

	GameRound getOne(int gameRoundId);

}