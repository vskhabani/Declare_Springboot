package declare.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@Table(name = "status")
@NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final int DRAFT = 1;
	public static final int ABORTED = 2;
	public static final int IN_PROGRESS = 3;
	public static final int COMPLETED = 4;
	public static final int CANCELLED = 5;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "status_id", updatable = false, unique = true, nullable = false)
	private int id;

	@Column(name = "active_ind", nullable = false, insertable = false)
	private boolean activeInd = true;

	@Column(nullable = false, length = 20)
	private String name;

	public Status() {
	}

	public int getStatusId() {
		return this.id;
	}

	protected void setStatusId(int statusId) {
		this.id = statusId;
	}

	public boolean getActiveInd() {
		return this.activeInd;
	}

	public void setActiveInd(boolean activeInd) {
		this.activeInd = activeInd;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}