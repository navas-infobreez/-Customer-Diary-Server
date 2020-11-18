package com.planet.customer.diary.customer_diary.model.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class CustomerDiaryDTO extends BaseDTO {

	private String invoiceNo;

	private String quotationNo;

	private String description;

	private boolean active;

	private Timestamp createdDate;

	private Date diaryDate;

	private Long documentNo;

	private boolean shiptoCustomerAddress;

	private Long customerId;

	private Long salesRepId;

	private double totalAmount;

	private String email;

	private String country;

	private String city;

	private String state;

	private String landmark;

	private String pinNo;

	private String address1;

	private String address2;

	private String contactNo;

	private String purpose;

	private String status;

	private List<CustomerDiaryLineDTO> customerDiaryLineDTOList;

	public CustomerDiaryDTO(final Long id, final Long documentNo, final Long customerId, final Long salesRepId) {
		super(id);
		this.documentNo = documentNo;
		this.customerId = customerId;
		this.salesRepId = salesRepId;
	}

	public CustomerDiaryDTO() {
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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getSalesRepId() {
		return salesRepId;
	}

	public void setSalesRepId(Long salesRepId) {
		this.salesRepId = salesRepId;
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

	public List<CustomerDiaryLineDTO> getCustomerDiaryLineDTOList() {
		return customerDiaryLineDTOList;
	}

	public void setCustomerDiaryLineDTOList(List<CustomerDiaryLineDTO> customerDiaryLineDTOList) {
		this.customerDiaryLineDTOList = customerDiaryLineDTOList;
	}

	@Override
	public String toString() {
		return "ProductDTO [DocumentNo=" + documentNo + ", customerId=" + customerId + ", salesRepId=" + salesRepId
				+ ", Description=" + description + ", Active=" + active + ", CustomerDiaryLineDTOList="
				+ customerDiaryLineDTOList + "]";
	}

}
