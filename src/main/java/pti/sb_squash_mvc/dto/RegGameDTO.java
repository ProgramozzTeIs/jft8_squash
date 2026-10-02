package pti.sb_squash_mvc.dto;

import java.time.LocalDate;

public class RegGameDTO {
	
	private Integer user1Id;
	private Integer user1Score;
	private Integer user2Id;
	private Integer user2Score;
	private Integer placeId;
	private LocalDate date;
	
	public RegGameDTO(Integer user1Id, Integer user1Score, Integer user2Id, Integer user2Score, Integer placeId,
			LocalDate date) {
		super();
		this.user1Id = user1Id;
		this.user1Score = user1Score;
		this.user2Id = user2Id;
		this.user2Score = user2Score;
		this.placeId = placeId;
		this.date = date;
	}

	public Integer getUser1Id() {
		return user1Id;
	}

	public void setUser1Id(Integer user1Id) {
		this.user1Id = user1Id;
	}

	public Integer getUser1Score() {
		return user1Score;
	}

	public void setUser1Score(Integer user1Score) {
		this.user1Score = user1Score;
	}

	public Integer getUser2Id() {
		return user2Id;
	}

	public void setUser2Id(Integer user2Id) {
		this.user2Id = user2Id;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
