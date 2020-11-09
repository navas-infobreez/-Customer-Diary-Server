package com.planet.customer.diary.customer_diary.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.planet.customer.diary.customer_diary.model.constants.CustomerDiaryPurpose;
import com.planet.customer.diary.customer_diary.model.constants.CustomerDiaryStatus;

@Entity
@Table(name = "TBL_CUSTOMER_DIARY",
		uniqueConstraints = @UniqueConstraint(name = "unique_Diary", columnNames = "DOCUMENT_NO"))
public class CustomerDiary extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -5627410044823351383L;

	@Column(name = "INVOICE_NO", unique = true)
	private String invoiceNo;
	
	@Column(name = "QUOTATION_NO", unique = true)
	private String quotationNo;
		
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "ACTIVE")
	private boolean active;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SALESREP_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private User salesRep;

	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;

	@Column(name = "DIARY_DATE")
	private Date diaryDate;
	
	@SequenceGenerator(name = "pk_sequence", sequenceName = "document_number_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	@Column(name = "DOCUMENT_NO", updatable = false, columnDefinition = "serial")
	private Long documentNo;

	@Column(name = "SHIP_CMR_ADDRS")
	private boolean shiptoCustomerAddress;


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

	@OneToMany(mappedBy = "customerDiary", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CustomerDiaryLine> customerDiaryLineList;
	
	public CustomerDiary() {

	}

	public CustomerDiary(final Long id) {
		super(id);
	}

	public CustomerDiary(Date diaryDate, Customer customer, User salesRep) {
		this.diaryDate = diaryDate;
		this.customer = customer;
		this.salesRep = salesRep;
		this.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		this.setShiptoCustomerAddress(true);
		this.setActive(true);
		this.purpose = CustomerDiaryPurpose.VISTED.name();
		this.status = CustomerDiaryStatus.DRAFTED.name();
		this.setTotalAmount(0);

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

	public Long getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(Long documentNo) {
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