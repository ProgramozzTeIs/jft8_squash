package pti.sb_squash_mvc.dto;

public class ExchangeRateDTO {

	private String currency;
	private Double rate;
	
	public ExchangeRateDTO(String currency, Double rate) {
		super();
		this.currency = currency;
		this.rate = rate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}
}
