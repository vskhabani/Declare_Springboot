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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the game_rounds database table.
 * 
 */
@Entity
@Table(name = "game_rounds")
@NamedQuery(name = "GameRound.findAll", query = "SELECT g FROM GameRound g")
public class GameRound implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "game_round_id", updatable = false, unique = true, nullable = false)
	private int id;

	@Column(name = "active_ind", nullable = false, insertable = false)
	private boolean activeInd = true;

	@Column(name = "end_date")
	private Timestamp endDate;

	@Column(name = "start_date", nullable = false)
	private Timestamp startDate;

	// bi-directional many-to-one association to Game
	@ManyToOne
	@JoinColumn(name = "game_id", nullable = false)
	private Game game;

	// uni-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name = "status_id", nullable = false)
	private Status status;

	// bi-directional many-to-one association to GameRound
	@OneToMany(mappedBy = "gameRound", fetch = FetchType.EAGER)
	private List<GamePlayerRound> gamePlayerRounds;

	public GameRound() {
	}

	public int getGameRoundId() {
		return this.id;
	}

	protected void setGameRoundId(int gameRoundId) {
		this.id = gameRoundId;
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

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}