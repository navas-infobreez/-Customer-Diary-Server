package com.planet.customer.diary.customer_diary.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TBL_PRODUCT_CATEGORY",
uniqueConstraints = @UniqueConstraint(name = "unique_product_category", columnNames = "NAME"))
public class ProductCategory extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 4491170760200679640L;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "SEARCHKEY")
	private String searchKey;
		
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "IS_ACTIVE")
	private boolean isActive;

	public ProductCategory() {

	}

	public ProductCategory(final Long id) {
		super(id);
	}

	public ProductCategory(final String name) {
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
		final ProductCategory other = (ProductCategory) obj;
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
		return "ProductCategory [name=" + name + ", seachkey=" + searchKey + ", description=" + description + ", id"
				+ super.getId() + "]";
	}

}