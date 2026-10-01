package pti.sb_squash_mvc.dto;

import java.time.LocalDate;

public class GameDTO {
    private UserDTO user1;
    private UserDTO user2;
    private GameResultDTO gameResult;
    private PlaceDTO place;
    private LocalDate date;

    public GameDTO(UserDTO user1, UserDTO user2, GameResultDTO gameResult, PlaceDTO place, LocalDate date) {
        this.user1 = user1;
        this.user2 = user2;
        this.gameResult = gameResult;
        this.place = place;
        this.date = date;
    }

    public UserDTO getUser1() {
        return user1;
    }

    public void setUser1(UserDTO user1) {
        this.user1 = user1;
    }

    public UserDTO getUser2() {
        return user2;
    }

    public void setUser2(UserDTO user2) {
        this.user2 = user2;
    }

    public GameResultDTO getGameResult() {
        return gameResult;
    }

    public void setGameResult(GameResultDTO gameResult) {
        this.gameResult = gameResult;
    }

    public PlaceDTO getPlace() {
        return place;
    }

    public void setPlace(PlaceDTO place) {
        this.place = place;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}