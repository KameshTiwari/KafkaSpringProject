package interviewproject.entity;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="Bets")
public class BetsEntity {
	@Id
	private Long id;
	@Column(name="numbets")
	private int numbets;
	@Column(name="game")
	private String game;
	@Column(name="stake")
	private Double stake;
	@Column(name="returns")
	private Double returns;
	@Column(name="clientId")
	private long clientid;
	// private Date date;

	public BetsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumbets() {
		return numbets;
	}

	public void setNumbets(int numbets) {
		this.numbets = numbets;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public Double getStake() {
		return stake;
	}

	public void setStake(Double stake) {
		this.stake = stake;
	}

	public Double getReturns() {
		return returns;
	}

	public void setReturns(Double returns) {
		this.returns = returns;
	}

	public long getClientid() {
		return clientid;
	}

	public void setClientid(long clientid) {
		this.clientid = clientid;
	}

	public BetsEntity(Long id, int numbets, String game, Double stake, Double returns, long clientid) {
		super();
		this.id = id;
		this.numbets = numbets;
		this.game = game;
		this.stake = stake;
		this.returns = returns;
		this.clientid = clientid;
		// this.date = date;
	}

	@Override
	public String toString() {
		return "BetsEntity [id=" + id + ", numbets=" + numbets + ", game=" + game + ", stake=" + stake + ", returns="
				+ returns + ", clientid=" + clientid + "]";
	}

}
