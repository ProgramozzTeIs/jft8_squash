package pti.sb_squash_mvc.dto;

public class PlaceDTO {
    private Integer id;
    private String name;
    private String address;
    private int rentalFee;
    private Double rentalFeeEUR;

    public PlaceDTO(Integer id, String name, String address, int rentalFee, Double rentalFeeEUR) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rentalFee = rentalFee;
        this.rentalFeeEUR = rentalFeeEUR;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(int rentalFee) {
        this.rentalFee = rentalFee;
    }

	public Double getRentalFeeEUR() {
		return rentalFeeEUR;
	}

	public void setRentalFeeEUR(Double rentalFeeEUR) {
		this.rentalFeeEUR = rentalFeeEUR;
	}
    
    
}
