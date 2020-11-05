package com.planet.customer.diary.customer_diary.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TBL_CUSTOMER_VISIT")
public class CustomerVisit extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6965526687264460384L;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CUSTOMER_DIARY_ID", nullable = false)
	private CustomerDiary customerDiary;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

	@Column(name = "VISIT_DATE")
	private Date date;

	@Column(name = "VISIT_TIME")
	private Timestamp time;
	
	@Column(name = "PLACE")
	private String place;	

	public CustomerVisit() {

	}

	public CustomerVisit(final Long id) {
		super(id);
	}

	public CustomerVisit(final Customer customer, final Date date, final Timestamp time) {
		super();
		this.customer = customer;
		this.date = date;
		this.time = time;
	}

	public CustomerDiary getCustomerDiary() {
		return customerDiary;
	}

	public void setCustomerDiary(CustomerDiary customerDiary) {
		this.customerDiary = customerDiary;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		final CustomerVisit other = (CustomerVisit) obj;
		if (customer == null) {
			if (other.customer != null) {
				return false;
			}
		} else if (!customer.equals(other.customer)) {
			return false;
		}
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (time == null) {
			if (other.time != null) {
				return false;
			}
		} else if (!time.equals(other.time)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CustomerVisit [Customer=" + customer + ", date=" + date + ", time=" + time + "]";
	}

}