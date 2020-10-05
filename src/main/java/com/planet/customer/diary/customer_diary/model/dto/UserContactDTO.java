package com.planet.customer.diary.customer_diary.model.dto;


public class UserContactDTO extends BaseDTO {

	private String email;

	private Long phoneNumber;
	
	private String country;
	
	private String city;
	
	private String address1;
	
	private String address2;
	
	

	public UserContactDTO(final Long userContactId, final String email, final Long phoneNumber) {
		super(userContactId);
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public UserContactDTO() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(final Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "UserContactDTO [email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}

}
