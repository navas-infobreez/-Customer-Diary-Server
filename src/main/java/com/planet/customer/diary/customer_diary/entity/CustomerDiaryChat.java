package com.planet.customer.diary.customer_diary.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_CUSTOMER_DIARY_CHAT")
public class CustomerDiaryChat extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 5245372730336732932L;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CUSTOMER_DIARY_ID", nullable = false)
	private CustomerDiary customerDiary;
	
	@Column(name = "MESSAGE", nullable = false)
	private String message;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;


	public CustomerDiaryChat() {
	}

	public CustomerDiaryChat(CustomerDiary customerDiary, String message, User user) {
		this.customerDiary = customerDiary;
		this.message = message;
		this.user = user;
	}

	public CustomerDiary getCustomerDiary() {
		return customerDiary;
	}

	public void setCustomerDiary(CustomerDiary customerDiary) {
		this.customerDiary = customerDiary;
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
		return "CustomerDiaryLine [User=" + user.getFirstName() + ", Message=" + message + ", id"
				+ super.getId() + "]";
	}

}
