package pti.sb_squash_mvc.dto;

public class SimpleResponseDTO {
    private Integer userId;
    private String response;

    public SimpleResponseDTO(Integer userId, String response) {
        this.userId = userId;
        this.response = response;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
