package declare.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the game_players database table.
 * 
 */
@Entity
@Table(name = "game_players")
@NamedQuery(name = "GamePlayer.findAll", query = "SELECT g FROM GamePlayer g")
public class GamePlayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "game_player_id", updatable = false, unique = true, nullable = false)
	private int id;

	@Column(name = "active_ind", nullable = false, insertable = false)
	private boolean activeInd = true;

	@Column(name = "num_rounds", nullable = false)
	private int numRounds;

	@Column(nullable = false)
	private int points;

	// bi-directional many-to-one association to Game
	@ManyToOne
	@JoinColumn(name = "game_id", nullable = false)
	private Game game;

	// uni-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name = "player_id", nullable = false)
	private Player player;

	// uni-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name = "status_id", nullable = false)
	private Status status;

	public GamePlayer() {
	}

	public int getGamePlayerId() {
		return this.id;
	}

	protected void setGamePlayerId(int gamePlayerId) {
		this.id = gamePlayerId;
	}

	public boolean getActiveInd() {
		return this.activeInd;
	}

	public void setActiveInd(boolean activeInd) {
		this.activeInd = activeInd;
	}

	public int getNumRounds() {
		return this.numRounds;
	}

	public void setNumRounds(int numRounds) {
		this.numRounds = numRounds;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}