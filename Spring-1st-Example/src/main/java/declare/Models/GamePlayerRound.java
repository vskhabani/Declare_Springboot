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
 * The persistent class for the game_player_rounds database table.
 * 
 */
@Entity
@Table(name = "game_player_rounds")
@NamedQuery(name = "GamePlayerRound.findAll", query = "SELECT g FROM GamePlayerRound g")
public class GamePlayerRound implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "game_player_round_id", updatable = false, unique = true, nullable = false)
	private int id;

	@Column(name = "active_ind", nullable = false, insertable = false)
	private boolean activeInd = true;

	@Column(name = "declare_ind", nullable = false)
	private boolean declareInd;

	@Column(nullable = false)
	private int points;

	// bi-directional many-to-one association to GameRound
	@ManyToOne
	@JoinColumn(name = "game_round_id", nullable = false)
	private GameRound gameRound;

	// bi-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name = "player_id", nullable = false)
	private Player player;

	public GamePlayerRound() {
	}

	public int getGamePlayerRoundId() {
		return this.id;
	}

	protected void setGamePlayerRoundId(int gamePlayerRoundId) {
		this.id = gamePlayerRoundId;
	}

	public boolean getActiveInd() {
		return this.activeInd;
	}

	public void setActiveInd(boolean activeInd) {
		this.activeInd = activeInd;
	}

	public boolean getDeclareInd() {
		return this.declareInd;
	}

	public void setDeclareInd(boolean declareInd) {
		this.declareInd = declareInd;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public GameRound getGameRound() {
		return this.gameRound;
	}

	public void setGameRound(GameRound gameRound) {
		this.gameRound = gameRound;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}