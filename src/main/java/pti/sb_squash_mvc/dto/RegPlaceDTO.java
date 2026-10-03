package pti.sb_squash_mvc.dto;

public class RegPlaceDTO {
    private String name;
    private String address;
    private Integer rentalFee;

    public RegPlaceDTO(String name, String address, Integer rentalFee) {
        this.name = name;
        this.address = address;
        this.rentalFee = rentalFee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(Integer rentalFee) {
        this.rentalFee = rentalFee;
    }
}