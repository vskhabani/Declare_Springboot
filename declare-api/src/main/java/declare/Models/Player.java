package declare.Models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the player database table.
 * 
 */
@Entity
@Table(name = "player")
@NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p")
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "player_id", updatable = false, unique = true, nullable = false)
	private int id;

	@Column(name = "active_ind", nullable = false, insertable = false)
	private boolean activeInd = true;

	@Column(name = "deactivation_date")
	private Timestamp deactivationDate;

	@Column(length = 50)
	private String email;

	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName;

	@Column(length = 255)
	private String password;

	@Column(name = "signup_date", nullable = false)
	private Timestamp signupDate;

	@Column(nullable = false, length = 20)
	private String username;

	// bi-directional many-to-one association to GamePlayerRound
	@OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
	private Set<GamePlayerRound> playerRounds;

	// bi-directional many-to-many association to Game
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "game_players", joinColumns = {
			@JoinColumn(name = "player_id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "game_id", nullable = false) })
	private Set<Game> games;

	public Player() {

	}

	public Player(String email, String firstName, String lastName, String username, String password) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password.trim().isEmpty() ? "token" : password;
		this.signupDate = new Timestamp(System.nanoTime());
	}

	public int getPlayerId() {
		return this.id;
	}

	protected void setPlayerId(int playerId) {
		this.id = playerId;
	}

	public boolean getActiveInd() {
		return this.activeInd;
	}

	public void setActiveInd(boolean activeInd) {
		this.activeInd = activeInd;
	}

	public Timestamp getDeactivationDate() {
		return this.deactivationDate;
	}

	public void setDeactivationDate(Timestamp deactivationDate) {
		this.deactivationDate = deactivationDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public Set<GamePlayerRound> getGamePlayerRounds() {
		return this.playerRounds;
	}

	public void setGamePlayerRounds(Set<GamePlayerRound> gamePlayerRounds) {
		this.playerRounds = gamePlayerRounds;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getSignupDate() {
		return this.signupDate;
	}

	public void setSignupDate(Timestamp signupDate) {
		this.signupDate = signupDate;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Game> getGames() {
		return this.games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

}