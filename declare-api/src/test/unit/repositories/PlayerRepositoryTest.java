package unit.repositories;

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

import declare.Models.Player;
import declare.Repositories.PlayerRepository;

@ContextConfiguration(classes = { PlayerRepositoryTest.class })
@EnableJpaRepositories(basePackages = { "declare.*" })
@DataJpaTest
@EntityScan("declare.*")
class PlayerRepositoryTest {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private PlayerRepository playerRepository;

	@Test
	void injectedComponentsAreNotNull() {
		Assert.notNull(dataSource, "Data Source is null");
		Assert.notNull(jdbcTemplate, "JDBC Template is null");
		Assert.notNull(entityManager, "Entity Manager is null");
		Assert.notNull(playerRepository, "Player Repository is null");
	}

	@Test
	void findsByUsernameAndPassword() {
		Player player = playerRepository.findByUsernameAndPassword("testuser1", "testpassword1");
		Assert.notNull(player, "Player is null.");
		Assert.isTrue(player.getEmail().equals("email@email.com"), "Email does not match");
		Assert.isTrue(player.getPlayerId() == 1, "Player ID does not match");
	}

	@Test
	void getsOne() {
		Player player = playerRepository.getOne(1);
		Assert.notNull(player, "Player is null.");
		Assert.isTrue(player.getEmail().equals("email@email.com"), "Email does not match");
	}

	@Test
	void getsGamesAndRounds() {
		Player player = playerRepository.getOne(1);
		Assert.notNull(player, "Player is null.");
		Assert.isTrue(player.getGames().size() == 3, "Player's games do not match");
		Assert.isTrue(player.getGamePlayerRounds().size() == 4, "Player's rounds do not match");
	}
}