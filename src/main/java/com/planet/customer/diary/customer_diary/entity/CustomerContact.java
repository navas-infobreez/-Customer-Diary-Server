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
@Table(name = "TBL_CUSTOMER_CONTACT",
uniqueConstraints = @UniqueConstraint(name = "unique_customer_contact", columnNames = "CUSTOMER_ID"))
public class CustomerContact extends BaseEntity implements Serializable {


	private static final long serialVersionUID = 7466140166985754157L;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

	@Column(name = "EMAIL")
	private String email;
		
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "LANDMARK")
	private String landmark;
	
	@Column(name = "PIN_NO")
	private String pinNo;
	
	@Column(name = "ADDRESS1")
	private String address1;
	
	@Column(name = "ADDRESS2")
	private String address2;
	
	@Column(name = "CONTACT_NO",
			unique = true)
	private String contactNo;
	
	@Column(name = "CONTACT_NO_2")
	private String contactNo2;
	

	public CustomerContact() {

	}

	public CustomerContact(final Long id, final String email, final String contactNo) {
		super(id);
		this.email = email;
		this.contactNo = contactNo;
	}

	public CustomerContact(final Customer customer, final String email, final String contactNo) {
		super();
		this.customer = customer;
		this.email = email;
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPinNo() {
		return pinNo;
	}

	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getContactNo2() {
		return contactNo2;
	}

	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((contactNo == null) ? 0 : contactNo.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
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
		final CustomerContact other = (CustomerContact) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (contactNo == null) {
			if (other.contactNo != null) {
				return false;
			}
		} else if (!contactNo.equals(other.contactNo)) {
			return false;
		}
		if (customer == null) {
			if (other.customer != null) {
				return false;
			}
		} else if (!customer.equals(other.customer)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CustomerrContact [customer=" + customer + ", email=" + email + ", contactNo=" + contactNo + "]";
	}

}