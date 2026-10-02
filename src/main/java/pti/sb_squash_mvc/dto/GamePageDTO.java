package pti.sb_squash_mvc.dto;

import java.util.List;

public class GamePageDTO {
	
	private List<GameDTO> games;
	private List<UserDTO> allUser;
	private List<PlaceDTO> allPlace;
	
	public GamePageDTO(List<GameDTO> games, List<UserDTO> allUser, List<PlaceDTO> allPlace) {
		super();
		this.games = games;
		this.allUser = allUser;
		this.allPlace = allPlace;
	}

	public List<GameDTO> getGames() {
		return games;
	}

	public void setGames(List<GameDTO> games) {
		this.games = games;
	}

	public List<UserDTO> getAllUser() {
		return allUser;
	}

	public void setAllUser(List<UserDTO> allUser) {
		this.allUser = allUser;
	}

	public List<PlaceDTO> getAllPlace() {
		return allPlace;
	}

	public void setAllPlace(List<PlaceDTO> allPlace) {
		this.allPlace = allPlace;
	}
	
	

}
