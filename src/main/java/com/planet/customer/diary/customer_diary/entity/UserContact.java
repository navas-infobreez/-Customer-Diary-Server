package com.planet.customer.diary.customer_diary.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TBL_USER_CONTACT",
uniqueConstraints = @UniqueConstraint(name = "unique_user_contact", columnNames = "USER_ID"))
public class UserContact extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -410289978826615196L;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "ADDRESS1")
	private String address1;
	
	@Column(name = "ADDRESS2")
	private String address2;
	

	public UserContact() {

	}

	public UserContact(final Long id, final String email, final Long phoneNumber) {
		super(id);
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public UserContact(final User user, final String email, final Long phoneNumber) {
		super();
		this.user = user;
		this.email = email;
		this.phoneNumber = phoneNumber;
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

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final UserContact other = (UserContact) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (phoneNumber == null) {
			if (other.phoneNumber != null) {
				return false;
			}
		} else if (!phoneNumber.equals(other.phoneNumber)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "UserContact [user=" + user + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}

}