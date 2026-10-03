package pti.sb_squash_mvc.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("game")
public class Game {

	@Id
	@Column("id")
	private Integer id;
	@Column("user1_id")
	private Integer user1Id;
	@Column("user2_id")
	private Integer user2Id;
	@Column("user1_score")
	private Integer user1Score;
	@Column("user2_score")
	private Integer user2Score;
	@Column("place_id")
	private Integer placeId;
	@Column("game_date")
	private LocalDate gameDate;

	public Game(Integer id, Integer user1Id, Integer user2Id, Integer user1Score, Integer user2Score, Integer placeId,
			LocalDate gameDate) {
		super();
		this.id = id;
		this.user1Id = user1Id;
		this.user2Id = user2Id;
		this.user1Score = user1Score;
		this.user2Score = user2Score;
		this.placeId = placeId;
		this.gameDate = gameDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser1Id() {
		return user1Id;
	}

	public void setUser1Id(Integer user1Id) {
		this.user1Id = user1Id;
	}

	public Integer getUser2Id() {
		return user2Id;
	}

	public void setUser2Id(Integer user2Id) {
		this.user2Id = user2Id;
	}

	public Integer getUser1Score() {
		return user1Score;
	}

	public void setUser1Score(Integer user1Score) {
		this.user1Score = user1Score;
	}

	public Integer getUser2Score() {
		return user2Score;
	}

	public void setUser2Score(Integer user2Score) {
		this.user2Score = user2Score;
	}

	public Integer getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	public LocalDate getGameDate() {
		return gameDate;
	}

	public void setGameDate(LocalDate gameDate) {
		this.gameDate = gameDate;
	}

}
