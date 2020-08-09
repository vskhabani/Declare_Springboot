package declare.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import declare.Models.GamePlayerRound;

@Repository
public interface GamePlayerRoundRepository extends JpaRepository<GamePlayerRound, Integer> {

	List<GamePlayerRound> findByGameRoundIdAndPlayerId(int gameRoundId, int gamePlayerId);

	List<GamePlayerRound> findByGameRoundId(int gameRoundId);

	GamePlayerRound getOne(int gamePlayerRoundId);

}