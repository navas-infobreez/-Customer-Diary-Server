package com.planet.customer.diary.customer_diary.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_CUSTOMER")
public class Customer extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 7087691250932516989L;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "SEARCH_KEY")
	private String searchKey;
	
	@Column(name = "GST_No")
	private String gstNo;	

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private CustomerContact customerContact;
	
	public Customer(final String firstName, final String lastName,final String searchKey) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.searchKey = searchKey;
	}

	public Customer() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}


	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public CustomerContact getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(CustomerContact customerContact) {
		this.customerContact = customerContact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((searchKey == null) ? 0 : searchKey.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Customer other = (Customer) obj;
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (searchKey == null) {
			if (other.searchKey != null) {
				return false;
			}
		} else if (!searchKey.equals(other.searchKey)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", searchKey=" + searchKey + ", customerContact="
				+ customerContact.getContactNo() + "]";
	}

}
