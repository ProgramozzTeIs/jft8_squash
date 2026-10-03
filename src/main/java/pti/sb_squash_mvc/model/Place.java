package pti.sb_squash_mvc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("place")
public class Place {
	
	@Id
	@Column("id")
	private Integer id;
	@Column("name")
	private String name;
	@Column("address")
	private String address;
	@Column("rent_fee")
	private Integer rentFee;
	
	public Place(Integer id, String name, String address, Integer rentFee) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.rentFee = rentFee;
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

	public Integer getRentFee() {
		return rentFee;
	}

	public void setRentFee(Integer rentFee) {
		this.rentFee = rentFee;
	}

}
