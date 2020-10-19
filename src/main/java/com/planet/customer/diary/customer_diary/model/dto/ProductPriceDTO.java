package com.planet.customer.diary.customer_diary.model.dto;

import javax.persistence.Column;

public class ProductPriceDTO extends BaseDTO {

	private Long productId;

	private Long uomId;

	private double purchasePrice;

	private double salesPrice;

	@Column(name = "DISCNT_SALES_PRICE")
	private double discntSalesPrice;

	public ProductPriceDTO(final Long id, final Long productId, final Long uomId) {
		super(id);
		this.productId = productId;
		this.uomId = uomId;
	}
	
	public ProductPriceDTO() {
		
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

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public double getDiscntSalesPrice() {
		return discntSalesPrice;
	}

	public void setDiscntSalesPrice(double discntSalesPrice) {
		this.discntSalesPrice = discntSalesPrice;
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
		return "ProductPriceDTO [productId=" + productId + ", uomId=" + uomId + ", purchasePrice=" + purchasePrice
				+ ", salesPrice=" + salesPrice + ", discntSalesPrice=" + discntSalesPrice + "]";
	}

}
