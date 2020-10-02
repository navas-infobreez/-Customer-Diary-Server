package com.planet.customer.diary.customer_diary.model.dto;

public class UserContactDTO extends BaseDTO {

	private String email;

	private Long phoneNumber;

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
