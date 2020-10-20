package com.planet.customer.diary.customer_diary.model.dto;

public class ProductCategoryDTO extends BaseDTO {

	private String name;

	private String searchKey;

	private String description;

	private boolean active;


	public ProductCategoryDTO(final Long id, final String name, final String searchKey, final boolean active) {
		super(id);
		this.name = name;
		this.searchKey = searchKey;
		this.active = active;
	}
	
	public ProductCategoryDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
		return "UserRoleDTO [name=" + name + ", description=" + description + ", searchKey=" + searchKey + ", active="
				+ active + "]";
	}

}
