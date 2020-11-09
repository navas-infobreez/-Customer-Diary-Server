package com.planet.customer.diary.customer_diary.model.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class CustomerVisitDTO extends BaseDTO {

	private Long customerDiaryId;

	private Long customerId;

	private Date date;
	
	private Timestamp time;
	
	private String place;
		

	public CustomerVisitDTO(final Long customerVisitId, final long customerDiaryId, final Long customerId) {
		super(customerVisitId);
		this.customerDiaryId = customerDiaryId;
		this.customerId = customerId;
	}

	public CustomerVisitDTO() {
	}

	public Long getCustomerDiaryId() {
		return customerDiaryId;
	}

	public void setCustomerDiaryId(Long customerDiaryId) {
		this.customerDiaryId = customerDiaryId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
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
		return "CustomerVisitDTO [date=" + date + ", time=" + time + ", place="+ place +"]";
	}

}
