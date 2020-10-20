package com.planet.customer.diary.customer_diary.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "TBL_PRODUCT_PRICE", uniqueConstraints = @UniqueConstraint(name = "unique_uom_product_price", columnNames = {
		"PRODUCT_ID", "UOM_ID" }))
public class ProductPrice extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 4682275527304534098L;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UOM_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private UOM uom;

	@Column(name = "PURCHASE_PRICE")
	private double purchasePrice;

	@Column(name = "SALES_PRICE")
	private double salesPrice;

	@Column(name = "DISCNT_SALES_PRICE")
	private double discntSalesPrice;

	public ProductPrice(final Product product, UOM uom) {
		this.product = product;
		this.uom = uom;
	}

	public ProductPrice() {
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public UOM getUom() {
		return uom;
	}

	public void setUom(UOM uom) {
		this.uom = uom;
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
		return "ProductPrice [Product=" + product.getName() + ", UOM=" + uom.getName() + ", PurchasePrice="
				+ purchasePrice + ", SalesPrice=" + salesPrice + ", DiscountPrice=" + discntSalesPrice + ", id"
				+ super.getId() + "]";
	}

}
