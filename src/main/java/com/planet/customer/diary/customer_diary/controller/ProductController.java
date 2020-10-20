package com.planet.customer.diary.customer_diary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.planet.customer.diary.customer_diary.model.dto.ProductCategoryDTO;
import com.planet.customer.diary.customer_diary.model.dto.ProductDTO;
import com.planet.customer.diary.customer_diary.model.dto.ResponseDTO;
import com.planet.customer.diary.customer_diary.service.ProductCategoryService;
import com.planet.customer.diary.customer_diary.service.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductCategoryService productCategoryService;

	@GetMapping(value = "getproduct")
	public ResponseDTO<ProductDTO> getProductDetails(@RequestParam String pid) {
		final Long id = Long.valueOf(pid);
		final ProductDTO product = productService.findByProductId(id);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the product details", product);
	}
	
	@GetMapping(value = "deleteproduct")
	public ResponseDTO<ProductDTO> deleteProduct(@RequestParam String pid) {
		final Long id = Long.valueOf(pid);
		productService.delete(id);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully deleted product details",
				null);
	}
	
	@GetMapping(value = "getprodutsbycategoryId")
	public ResponseDTO<List<ProductDTO>> getProductDetailsbycategoryId(@RequestParam String pid) {
		final Long pcategoryId = Long.valueOf(pid);
		final List<ProductDTO> products = productService.findByProductCategoryId(pcategoryId);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the products",
				products);
	}
	
	@GetMapping(value = "getallproduct")
	public ResponseDTO<List<ProductDTO>> getAllProduct() {
		final List<ProductDTO> products = productService.findAll();
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the all products", products);
	}

	@GetMapping(value = "getallproduct")
	public ResponseDTO<List<ProductDTO>> getAllActiveProduct() {
		final List<ProductDTO> products = productService.getAllActiveProduct();
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the all active products", products);
	}
	
	@PostMapping(value = "createorupdateproduct")
	public ResponseDTO<ProductDTO> createOrUpdateProduct(@RequestBody final ProductDTO productDTO) {
		final ProductDTO product = productService.createOrUpdateProduct(productDTO);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully updated the product",
				product);
	}
	
	@GetMapping(value = "getallproductcategory")
	public ResponseDTO<List<ProductCategoryDTO>> getAllProductCategory() {
		final List<ProductCategoryDTO> productCategory = productCategoryService.findAll();
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the all active product category",
				productCategory);
	}

	@GetMapping(value = "getproductcategory")
	public ResponseDTO<ProductCategoryDTO> getproductcategory(@RequestParam String pid) {
		final Long id = Long.valueOf(pid);
		final ProductCategoryDTO productCategory = productCategoryService.findCategoryId(id);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the product category details",
				productCategory);
	}

	@PostMapping(value = "createorupdateproductcategory")
	public ResponseDTO<ProductDTO> createorUpdateProductCategory(@RequestBody final ProductCategoryDTO productCategoryDTO) {
		final ProductCategoryDTO productCategory = productCategoryService
				.createOrUpdateProductCategory(productCategoryDTO);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully updated the product",
				productCategory);
	}

}