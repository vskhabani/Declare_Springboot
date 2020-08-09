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

import declare.Repositories.GameRoundRepository;

@ContextConfiguration(classes = { GameRoundRepositoryTest.class })
@EnableJpaRepositories(basePackages = { "declare.*" })
@DataJpaTest
@EntityScan("declare.*")
class GameRoundRepositoryTest {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private GameRoundRepository gameRoundRepository;

	@Test
	void injectedComponentsAreNotNull() {
		Assert.notNull(dataSource, "Data Source is null");
		Assert.notNull(jdbcTemplate, "JDBC Template is null");
		Assert.notNull(entityManager, "Entity Manager is null");
		Assert.notNull(gameRoundRepository, "Game Round Repository is null");
	}

}