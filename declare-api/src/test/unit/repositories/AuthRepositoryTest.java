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

import declare.Models.Auth;
import declare.Repositories.AuthRepository;

@ContextConfiguration(classes = { AuthRepositoryTest.class })
@EnableJpaRepositories(basePackages = { "declare.*" })
@DataJpaTest
@EntityScan("declare.*")
class AuthRepositoryTest {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private AuthRepository authRepository;

	@Test
	void injectedComponentsAreNotNull() {
		Assert.notNull(dataSource, "Data Source is null");
		Assert.notNull(jdbcTemplate, "JDBC Template is null");
		Assert.notNull(entityManager, "Entity Manager is null");
		Assert.notNull(authRepository, "Auth Repository is null");
	}

	@Test
	void findsByToken() {
		Auth auth = authRepository.findByToken("some token");
		Assert.notNull(auth, "Auth is null");
		Assert.isTrue(auth.getAuthId() == 10001, "Auth ID does not match");
	}

	@Test
	void getsOne() {
		Auth auth = authRepository.getOne(10001);
		Assert.notNull(auth, "Auth is null");
		Assert.isTrue(auth.getToken().equals("some token"), "Token does not match");
	}

	@Test
	void findByPlayerId() {
		Auth auth = authRepository.findByPlayerId(1);
		Assert.notNull(auth, "Auth is null");
		Assert.isTrue(auth.getAuthId() == 10001, "Auth ID does not match");
	}

}