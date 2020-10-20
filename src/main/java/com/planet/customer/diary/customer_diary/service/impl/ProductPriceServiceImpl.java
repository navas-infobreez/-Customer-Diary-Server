package com.planet.customer.diary.customer_diary.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planet.customer.diary.customer_diary.entity.Product;
import com.planet.customer.diary.customer_diary.entity.ProductPrice;
import com.planet.customer.diary.customer_diary.model.dto.ProductPriceDTO;
import com.planet.customer.diary.customer_diary.repository.GenericRepository;
import com.planet.customer.diary.customer_diary.service.ProductPriceService;

@Service
public class ProductPriceServiceImpl extends BasicServiceImpl implements ProductPriceService {

	@Autowired
	private GenericRepository genericRepository;

	@Override
	public List<ProductPrice> mapProductPriceDTOToEntity(final List<ProductPriceDTO> productPriceDTOList,
			final Product product) {
		// List<ProductPrice> actualProductPriceList = product.getProductPriceList();
		final List<ProductPrice> tempProductPriceList = new ArrayList<>();
		for (final ProductPriceDTO productPriceDTO : productPriceDTOList) {
			ProductPrice productPriceprice = productPriceDTO.getId() > 0 ? findById(productPriceDTO.getId())
					: new ProductPrice();
			// final UserRoleMap userRoleMap = actualRoleMaps != null &&
			// actualRoleMaps.size() > 0 ?
			// actualProductPriceList.stream().filter(aUserRoleMap ->
			// aUserRoleMap.getUserRole().getId().equals(userRoleDTO.getId())).
			// findFirst().get() : new UserRoleMap();
			productPriceprice.setPurchasePrice(productPriceDTO.getPurchasePrice());
			productPriceprice.setSalesPrice(productPriceDTO.getSalesPrice());
			productPriceprice.setDiscntSalesPrice(productPriceDTO.getDiscntSalesPrice());
			// productPriceprice.setUom(productPriceDTO.getUomId());
			if (productPriceprice.getProduct() == null) {
				productPriceprice.setProduct(product);
			}
			tempProductPriceList.add(productPriceprice);
		}
		return tempProductPriceList;
	}

	@Override
	public List<ProductPriceDTO> findByProductId(Long id) {
		// final List<ProductPriceDTO> userRoleList =
		// userRoleMapRepository.findByUserId(id);
		// return userRoleList != null && userRoleList.isEmpty() ? null : userRoleList;
		return null;
	}
	
	private ProductPrice findById(final Long id) {
		return genericRepository.findById(ProductPrice.class, id);
	}
	
}