package com.planet.customer.diary.customer_diary.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planet.customer.diary.customer_diary.entity.Product;
import com.planet.customer.diary.customer_diary.model.dto.ProductDTO;
import com.planet.customer.diary.customer_diary.repository.GenericRepository;
import com.planet.customer.diary.customer_diary.repository.ProductRepository;
import com.planet.customer.diary.customer_diary.service.ProductCategoryService;
import com.planet.customer.diary.customer_diary.service.ProductPriceService;
import com.planet.customer.diary.customer_diary.service.ProductService;

@Service(value = "productService")
public class ProductServiceImpl extends BasicServiceImpl implements ProductService {
		
	@Autowired
	@Qualifier("genericRepository")
	private GenericRepository genericRepository;

	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;

	@Autowired
	@Qualifier("productCategoryService")
	private ProductCategoryService productCategoryService;

	@Autowired
	private ProductPriceService productPriceService;

	
	private List<ProductDTO> mapProductEntityToDTO(final List<Product> productList) {
		return (List<ProductDTO>) mapEntitiesToDTOs(productList, ProductDTO.class);
	}

	private ProductDTO mapProductEntityToDTO(final Product product) {
		return mapEntityToDTO(product, ProductDTO.class);
	}

	private Product mapDTOToProductEntity(final ProductDTO productDTO) {
		Product product = null;
		if (productDTO.getId() != null && productDTO.getId() > 0) {
			product = findById(productDTO.getId());
			product.setActive(productDTO.isActive());
			product.setDescription(productDTO.getDescription());
			product.setName(productDTO.getName());
			product.setSearchKey(productDTO.getSearchKey());
		}else {
			product = new Product();
			product = (Product) mapDTOToEntity(productDTO, product);
		}
		product.setProductCategory(
				productCategoryService.mapProductCategoryDTOToEntity(productDTO.getProductCategory(),
						product.getProductCategory()));
		product.setProductPriceList(
				productPriceService.mapProductPriceDTOToEntity(productDTO.getProductPriceDTOList(), product));
		return product;
	}

	private Product findById(final Long id) {
		return genericRepository.findById(Product.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		final List<Product> productList = genericRepository.findAll(Product.class);
		return mapProductEntityToDTO(productList);
	}

	@Override
	@Transactional
	public void delete(final Long id) {
		final Product userRole = findById(id);
		if (userRole != null) {
			genericRepository.delete(userRole);
		}
	}

	
	@Override
	@Transactional(readOnly = true)
	public ProductDTO findByProductId(final Long id) {
		final Product product = findById(id);
		return mapProductEntityToDTO(product);
	}

	@Override
	@Transactional
	public ProductDTO createOrUpdateProduct(ProductDTO productDTO) {
		if (productDTO == null)
			throw new NullPointerException("No data found user role information");
		if (productDTO.getId() != null && productDTO.getId() > 0) {
			genericRepository.saveOrUpdate(mapDTOToProductEntity(productDTO));
		}else {
			final Serializable userId = genericRepository.save(mapDTOToProductEntity(productDTO));
			productDTO.setId((Long) userId);
		}					
		return productDTO;
	}

	@Override
	public List<ProductDTO> getAllActiveProduct() {
		List<Product> allActiveProduct = productRepository.getAllActiveProduct();
		return mapProductEntityToDTO(allActiveProduct);
	}

	@Override
	public List<ProductDTO> findByProductCategoryId(Long categoryId) {
		List<Product> productList = productRepository.findByProductCategoryId(categoryId);
		return mapProductEntityToDTO(productList);
	}
	
}