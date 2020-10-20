package com.planet.customer.diary.customer_diary.model.dto;

import java.util.List;

public class ProductDTO extends BaseDTO {

	private String name;

	private String searchKey;

	private String description;
	
	private boolean active;

	private ProductCategoryDTO productCategory;

	private List<ProductPriceDTO> productPriceDTOList;

	public ProductDTO(final Long id, final String name, final String searchKey) {
		super(id);
		this.name = name;
		this.searchKey = searchKey;
	}

	public ProductDTO() {
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


	public List<ProductPriceDTO> getProductPriceDTOList() {
		return productPriceDTOList;
	}

	public void setProductPriceDTOList(List<ProductPriceDTO> productPriceDTOList) {
		this.productPriceDTOList = productPriceDTOList;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ProductCategoryDTO getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategoryDTO productCategory) {
		this.productCategory = productCategory;
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
		return "ProductDTO [Name=" + name + ", SearchKey=" + searchKey + ", Description=" + description + ", Active="
				+ active + ", productPriceDTOList=" + productPriceDTOList + "]";
	}


}
