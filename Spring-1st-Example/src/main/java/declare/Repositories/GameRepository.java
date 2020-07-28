package declare.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import declare.Models.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

	List<Game> findByStatusId(int statusId);

	Game getOne(int gameId);

}