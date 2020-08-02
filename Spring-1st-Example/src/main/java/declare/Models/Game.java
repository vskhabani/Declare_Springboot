package declare.Models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the game database table.
 * 
 */
@Entity
@Table(name = "game")
@NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "game_id", updatable = false, unique = true, nullable = false)
	private int id;

	@Column(name = "active_ind", nullable = false, insertable = false)
	private boolean activeInd = true;

	@Column(name = "end_date")
	private Timestamp endDate;

	@Column(name = "num_players")
	private int numPlayers;

	@Column(name = "start_date", nullable = false)
	private Timestamp startDate;

	// uni-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name = "status_id", referencedColumnName = "status_id", nullable = false)
	private Status status;

	// bi-directional many-to-one association to GameRound
	@OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
	private List<GameRound> gameRounds;

	// bi-directional many-to-many association to GamePlayerRound
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "game_rounds", joinColumns = {
			@JoinColumn(name = "game_id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "game_round_id", referencedColumnName = "game_round_id", table = "game_player_rounds", nullable = false) })
	private List<GamePlayerRound> gamePlayerRounds;

	public Game() {
	}

	public int getGameId() {
		return this.id;
	}

	protected void setGameId(int gameId) {
		this.id = gameId;
	}

	public boolean getActiveInd() {
		return this.activeInd;
	}

	public void setActiveInd(boolean activeInd) {
		this.activeInd = activeInd;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public int getNumPlayers() {
		return this.numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Status getGameStatus() {
		return this.status;
	}

	public void setGameStatus(Status status) {
		this.status = status;
	}

	public List<GameRound> getGameRounds() {
		return this.gameRounds;
	}

	public void setGameRounds(List<GameRound> gameRounds) {
		this.gameRounds = gameRounds;
	}

	public GameRound addGameRound(GameRound gameRound) {
		getGameRounds().add(gameRound);
		gameRound.setGame(this);

		return gameRound;
	}

	public GameRound removeGameRound(GameRound gameRound) {
		getGameRounds().remove(gameRound);
		gameRound.setGame(null);

		return gameRound;
	}
}