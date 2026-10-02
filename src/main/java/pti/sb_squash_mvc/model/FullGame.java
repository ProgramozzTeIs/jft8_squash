package pti.sb_squash_mvc.model;

import java.time.LocalDate;

public class FullGame {
    private Integer user1Id;
    private String user1Name;
    private Integer user2Id;
    private String user2Name;
    private Integer user1Score;
    private Integer user2Score;
    private Integer placeId;
    private String placeName;
    private String address;
    private Integer rentFee;
    private LocalDate gameDate;

    public FullGame(Integer user1Id, String user1Name, Integer user2Id, String user2Name, Integer user1Score, Integer user2Score, Integer placeId, String placeName, String address, Integer rentFee, LocalDate gameDate) {
        this.user1Id = user1Id;
        this.user1Name = user1Name;
        this.user2Id = user2Id;
        this.user2Name = user2Name;
        this.user1Score = user1Score;
        this.user2Score = user2Score;
        this.placeId = placeId;
        this.placeName = placeName;
        this.address = address;
        this.rentFee = rentFee;
        this.gameDate = gameDate;
    }

    public Integer getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(Integer user1Id) {
        this.user1Id = user1Id;
    }

    public String getUser1Name() {
        return user1Name;
    }

    public void setUser1Name(String user1Name) {
        this.user1Name = user1Name;
    }

    public Integer getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(Integer user2Id) {
        this.user2Id = user2Id;
    }

    public String getUser2Name() {
        return user2Name;
    }

    public void setUser2Name(String user2Name) {
        this.user2Name = user2Name;
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

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRentFee() {
        return rentFee;
    }

    public void setRentFee(Integer rentFee) {
        this.rentFee = rentFee;
    }

    public LocalDate getGameDate() {
        return gameDate;
    }

    public void setGameDate(LocalDate gameDate) {
        this.gameDate = gameDate;
    }
}