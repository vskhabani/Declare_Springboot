package declare.Models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the auth database table.
 * 
 */
@Entity
@Table(name = "auth")
@NamedQuery(name = "Auth.findAll", query = "SELECT a FROM Auth a")
public class Auth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auth_id", updatable = false, nullable = false)
	private int id;

	@Column(nullable = false, length = 30)
	private String hash;

	@Column(name = "last_login_date", nullable = false)
	private Timestamp lastLoginDate;

	@Column(name = "last_password_change_date", nullable = false)
	private Timestamp lastPasswordChangeDate;

	@Column(name = "player_id")
	private Integer playerId;

	@Column(name = "salted_password", nullable = false, length = 20)
	private String saltedPassword;

	@Column(nullable = false, length = 30)
	private String token;

	@Column(name = "active_ind", nullable = false, insertable = false)
	private boolean activeInd = true;

	public Auth() {

	}

	public Auth(String token, int playerId) {

	}

	public boolean getActiveInd() {
		return this.activeInd;
	}

	public void setActiveInd(boolean activeInd) {
		this.activeInd = activeInd;
	}

	public int getAuthId() {
		return this.id;
	}

	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Timestamp getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Timestamp getLastPasswordChangeDate() {
		return this.lastPasswordChangeDate;
	}

	public void setLastPasswordChangeDate(Timestamp lastPasswordChangeDate) {
		this.lastPasswordChangeDate = lastPasswordChangeDate;
	}

	public int getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getSaltedPassword() {
		return this.saltedPassword;
	}

	public void setSaltedPassword(String saltedPassword) {
		this.saltedPassword = saltedPassword;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}