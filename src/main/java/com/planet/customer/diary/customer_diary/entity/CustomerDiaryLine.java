package com.planet.customer.diary.customer_diary.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TBL_CUSTOMER_DIARY_LINE", uniqueConstraints = @UniqueConstraint(name = "unique_uom_product_diary", columnNames = {
		"PRODUCT_ID", "UOM_ID", "CUSTOMER_DIARY_ID" }))
public class CustomerDiaryLine extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 7117271549414306018L;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CUSTOMER_DIARY_ID", nullable = false)
	private CustomerDiary customerDiary;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product product;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UOM_ID", nullable = false)
	private UOM uom;

	@Column(name = "SALES_PRICE")
	private double salesPrice;

	@Column(name = "QTY")
	private double qty;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PRODUCT_CATEGORY_ID", nullable = false)
	private ProductCategory productCategory;

	@Column(name = "DESCRIPTION")
	private String description;


	public CustomerDiaryLine() {
	}


	public UOM getUom() {
		return uom;
	}

	public void setUom(UOM uom) {
		this.uom = uom;
	}


	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public CustomerDiary getCustomerDiary() {
		return customerDiary;
	}

	public void setCustomerDiary(CustomerDiary customerDiary) {
		this.customerDiary = customerDiary;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
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
		return "CustomerDiaryLine [Product=" + product.getName() + ", UOM=" + uom.getName() + ", SalesPrice="
				+ salesPrice + ", id"
				+ super.getId() + "]";
	}

}
