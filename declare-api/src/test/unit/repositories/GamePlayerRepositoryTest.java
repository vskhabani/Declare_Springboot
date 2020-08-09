package unit.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import declare.Models.GamePlayer;
import declare.Repositories.GamePlayerRepository;

@ContextConfiguration(classes = { GamePlayerRepositoryTest.class })
@EnableJpaRepositories(basePackages = { "declare.*" })
@DataJpaTest
@EntityScan("declare.*")
class GamePlayerRepositoryTest {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private GamePlayerRepository gamePlayerRepository;

	@Test
	void injectedComponentsAreNotNull() {
		Assert.notNull(dataSource, "Data Source is null");
		Assert.notNull(jdbcTemplate, "JDBC Template is null");
		Assert.notNull(entityManager, "Entity Manager is null");
		Assert.notNull(gamePlayerRepository, "Game Player Repository is null");
	}

	@Test
	void findByGameId() {
		List<GamePlayer> gamePlayers = gamePlayerRepository.findByGameId(1);
		Assert.isTrue(gamePlayers.size() == 4, "Invalid Number of Players Found");
	}

	@Test
	void findByPlayerId() {
		GamePlayer player = gamePlayerRepository.findByGameIdAndPlayerId(1, 1);
		Assert.notNull(player, "Player is null");
		Assert.isTrue(player.getPlayer().getPlayerId() == 1, "Player found does not match");
	}

	@Test
	void getsOne() {
		GamePlayer player = gamePlayerRepository.getOne(7);
		Assert.notNull(player, "Player is null.");
		Assert.isTrue(player.getPlayer().getPlayerId() == 2, "Player found does not match");
	}
}