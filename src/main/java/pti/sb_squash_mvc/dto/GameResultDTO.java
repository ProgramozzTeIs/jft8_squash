package pti.sb_squash_mvc.dto;

public class GameResultDTO {

	private int user1Score;
	private int user2Score;

	public GameResultDTO() {
		super();
	}

	public GameResultDTO(int user1Score, int user2Score) {
		super();
		this.user1Score = user1Score;
		this.user2Score = user2Score;
	}

	public int getUser1Score() {
		return user1Score;
	}

	public void setUser1Score(int user1Score) {
		this.user1Score = user1Score;
	}

	public int getUser2Score() {
		return user2Score;
	}

	public void setUser2Score(int user2Score) {
		this.user2Score = user2Score;
	}

}
