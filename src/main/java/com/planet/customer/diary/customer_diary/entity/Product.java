package com.planet.customer.diary.customer_diary.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "TBL_PRODUCT",
uniqueConstraints = @UniqueConstraint(name = "unique_product", columnNames = "NAME"))
public class Product extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1300543173673077625L;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "SEARCHKEY")
	private String searchKey;
		
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "ACTIVE")
	private boolean active;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductPrice> productPriceList;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PRODUCT_CATEGORY_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private ProductCategory productCategory;
	
	public Product() {

	}

	public Product(final Long id) {
		super(id);
	}

	public Product(final String name) {
		super();
		this.name = name;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<ProductPrice> getProductPriceList() {
		return productPriceList;
	}

	public void setProductPriceList(List<ProductPrice> productPriceList) {
		if (productPriceList != null) {
			if (this.productPriceList != null) {
				this.productPriceList.clear();
				this.productPriceList.addAll(productPriceList);
			} else {
				this.productPriceList = (productPriceList);
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((searchKey == null) ? 0 : searchKey.hashCode());
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
		final Product other = (Product) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (searchKey == null) {
			if (other.searchKey != null) {
				return false;
			}
		} else if (!searchKey.equals(other.searchKey)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", seachkey=" + searchKey + ", ProductCategory=" + productCategory.getName()
				+ ", description=" + description + ", id" + super.getId() + "]";
	}

}