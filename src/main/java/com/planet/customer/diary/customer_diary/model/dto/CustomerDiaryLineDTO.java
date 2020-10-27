package com.planet.customer.diary.customer_diary.model.dto;

public class CustomerDiaryLineDTO extends BaseDTO {

	private Long customerDiaryId;

	private Long productId;

	private Long uomId;

	private double salesPrice;

	private double qty;

	private Long productCategoryId;

	private String description;

	public CustomerDiaryLineDTO(final Long id, final Long customerDiaryId, final Long productId, final Long uomId) {
		super(id);
		this.customerDiaryId = customerDiaryId;
		this.productId = productId;
		this.uomId = uomId;
	}
	
	public CustomerDiaryLineDTO() {
		
	}

	public Long getCustomerDiaryId() {
		return customerDiaryId;
	}

	public void setCustomerDiaryId(Long customerDiaryId) {
		this.customerDiaryId = customerDiaryId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getUomId() {
		return uomId;
	}

	public void setUomId(Long uomId) {
		this.uomId = uomId;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "ProductPriceDTO [customerDiaryId=" + customerDiaryId+ "productId=" + productId + ", uomId=" + uomId + ", qty=" + qty
				+ ", salesPrice=" + salesPrice + ", productCategoryId=" + productCategoryId + "]";
	}


}
