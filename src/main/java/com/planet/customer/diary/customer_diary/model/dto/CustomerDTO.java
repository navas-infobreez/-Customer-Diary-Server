package com.planet.customer.diary.customer_diary.model.dto;

public class CustomerDTO extends BaseDTO {

	private String firstName;

	private String lastName;

	private String searchKey;
	
	private String gstNo;

	private CustomerContactDTO customerContact;
	
	public CustomerDTO(final Long id, final String searchKey) {
		super(id);
		this.searchKey = searchKey;
	}

	public CustomerDTO() {
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
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", searchKey=" + searchKey + "]";
	}

	public CustomerContactDTO getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(CustomerContactDTO customerContact) {
		this.customerContact = customerContact;
	}

}
