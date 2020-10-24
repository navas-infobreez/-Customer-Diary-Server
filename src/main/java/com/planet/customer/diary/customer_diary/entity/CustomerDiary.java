package com.planet.customer.diary.customer_diary.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TBL_CUSTOMER_DIARY",
		uniqueConstraints = @UniqueConstraint(name = "unique_Diary", columnNames = "DOCUMENT_NO"))
public class CustomerDiary extends BaseEntity implements Serializable {


	private static final long serialVersionUID = 7568415659209199204L;

	@Column(name = "INVOICE_NO", unique = true)
	private String invoiceNo;
	
	@Column(name = "QUOTATION_NO", unique = true)
	private String quotationNo;
		
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "ACTIVE")
	private boolean active;

	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;

	@Column(name = "DIARY_DATE")
	private Date diaryDate;

	@Column(name = "DOCUMENT_NO")
	private String documentNo;

	@Column(name = "SHIP_CMR_ADDRS")
	private boolean shiptoCustomerAddress;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
	private Customer customer;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SALESREP_ID", nullable = false)
	private User salesRep;

	@Column(name = "totalAmount")
	private double totalAmount;

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

	@Column(name = "CONTACT_NO")
	private String contactNo;
	
	@Column(name = "PURPOSE")
	private String purpose;

	@Column(name = "STATUS")
	private String status;

	@OneToMany(mappedBy = "customerDiaryLine", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CustomerDiaryLine> customerDiaryLineList;
	
	public CustomerDiary() {

	}

	public CustomerDiary(final Long id) {
		super(id);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getQuotationNo() {
		return quotationNo;
	}

	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Date getDiaryDate() {
		return diaryDate;
	}

	public void setDiaryDate(Date diaryDate) {
		this.diaryDate = diaryDate;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public boolean isShiptoCustomerAddress() {
		return shiptoCustomerAddress;
	}

	public void setShiptoCustomerAddress(boolean shiptoCustomerAddress) {
		this.shiptoCustomerAddress = shiptoCustomerAddress;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getSalesRep() {
		return salesRep;
	}

	public void setSalesRep(User salesRep) {
		this.salesRep = salesRep;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<CustomerDiaryLine> getCustomerDiaryLineList() {
		return customerDiaryLineList;
	}

	public void setCustomerDiaryLineList(List<CustomerDiaryLine> customerDiaryLineList) {
		this.customerDiaryLineList = customerDiaryLineList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((documentNo == null) ? 0 : documentNo.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if(obj == null)
			return false;
		
		if (this == obj) {
			return true;
		}
		if (super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CustomerDiary [documentNo=" + documentNo + ", customer=" + customer.getFirstName() + ", id"
				+ super.getId() + "]";
	}

}