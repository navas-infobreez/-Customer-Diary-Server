package com.planet.customer.diary.customer_diary.model.dto;

public class CustomerDiaryChatDTO extends BaseDTO {

	private Long customerDiaryId;
	
	private String message;

	private Long userId;

	public CustomerDiaryChatDTO() {
		
	}

	public Long getCustomerDiaryId() {
		return customerDiaryId;
	}

	public void setCustomerDiaryId(Long customerDiaryId) {
		this.customerDiaryId = customerDiaryId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
		return "CustomerDiaryChatDTO [customerDiaryId=" + customerDiaryId + "userId=" + userId + ", message=" + message
				+ "]";
	}


}
