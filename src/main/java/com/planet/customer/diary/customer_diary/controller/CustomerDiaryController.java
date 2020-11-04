package com.planet.customer.diary.customer_diary.controller;

import java.sql.Date;
import java.sql.Timestamp;
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

import com.planet.customer.diary.customer_diary.model.dto.CustomerDiaryDTO;
import com.planet.customer.diary.customer_diary.model.dto.CustomerDiaryLineDTO;
import com.planet.customer.diary.customer_diary.model.dto.CustomerVisitDTO;
import com.planet.customer.diary.customer_diary.model.dto.ProductDTO;
import com.planet.customer.diary.customer_diary.model.dto.ResponseDTO;
import com.planet.customer.diary.customer_diary.service.CustomerDiaryLineService;
import com.planet.customer.diary.customer_diary.service.CustomerDiaryService;
import com.planet.customer.diary.customer_diary.service.CustomerVisitService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "customerdiary")
public class CustomerDiaryController {

	@Autowired
	private CustomerDiaryService customerDiaryService;
	
	@Autowired
	private CustomerDiaryLineService customerDiaryLineService;
	
	@Autowired
	private CustomerVisitService customerVisitService;
	
	
	@PostMapping(value = "createorupdatecustomerdiary")
	public ResponseDTO<CustomerDiaryDTO> createOrUpdateCustomerDiary(@RequestBody final CustomerDiaryDTO customerDiaryDTO) {
		final CustomerDiaryDTO customerDiary = customerDiaryService.createOrUpdateCustomerDiary(customerDiaryDTO);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully updated the CustomerDiary",
				customerDiary);
	}
	
	@GetMapping(value = "getallcustomerdiary")
	public ResponseDTO<List<CustomerDiaryDTO>> getAllCustomerDiary() {
		final List<CustomerDiaryDTO> customerDiaryDTOs = customerDiaryService.findAll();
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the all customerdiarys", customerDiaryDTOs);
	}

	@GetMapping(value = "getallactivecustomerdiary")
	public ResponseDTO<List<CustomerDiaryDTO>> getAllActiveCustomerDiary() {
		final List<CustomerDiaryDTO> customerDiaryDTOs = customerDiaryService.getAllActiveCustomerDiary();
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the all active customerdiarys", customerDiaryDTOs);
	}
	
	@GetMapping(value = "getcustomerdiary")
	public ResponseDTO<CustomerDiaryDTO> getCustomerDiaryDetails(@RequestParam String cdid) {
		final Long id = Long.valueOf(cdid);
		final CustomerDiaryDTO customerDiaryDTO = customerDiaryService.findByCustomerDiaryId(id);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the customer diary details", customerDiaryDTO);
	}
	
	@GetMapping(value = "deletecustomerdiary")
	public ResponseDTO<ProductDTO> deleteCustomerDiary(@RequestParam String pid) {
		final Long id = Long.valueOf(pid);
		customerDiaryService.delete(id);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully deleted customer diary details",
				null);
	}
	
	@GetMapping(value = "getcustomerdiarybysalesrepId")
	public ResponseDTO<List<CustomerDiaryDTO>> getCustomerDiaryDetailsbySalesRepId(@RequestParam String salesrepid) {
		final Long userId = Long.valueOf(salesrepid);
		final List<CustomerDiaryDTO> customerDiaryDTOs = customerDiaryService.findBySalesRepId(userId);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the customerdiarys",
				customerDiaryDTOs);
	}
	
	
	@GetMapping(value = "getcustomerdiarybycustomerId")
	public ResponseDTO<List<CustomerDiaryDTO>> getCustomerDiaryDetailsbyCustomerId(@RequestParam String customerId) {
		final Long customer = Long.valueOf(customerId);
		final List<CustomerDiaryDTO> customerDiaryDTOs = customerDiaryService.findByCustomerId(customer);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the customerdiarys",
				customerDiaryDTOs);
	}

	@GetMapping(value = "getcustomerdiarybydocumentno")
	public ResponseDTO<List<CustomerDiaryDTO>> getCustomerDiaryDetailsbyDocumentNo(@RequestParam String documentNo) {
		final List<CustomerDiaryDTO> customerDiaryDTOs = customerDiaryService.findByDocumentNo(documentNo);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the customerdiarys",
				customerDiaryDTOs);
	}
	
	@GetMapping(value = "getcustomerdiarybyinvoiceNo")
	public ResponseDTO<List<CustomerDiaryDTO>> getCustomerDiaryDetailsbyInvoiceNo(@RequestParam String invoiceNo) {
		final List<CustomerDiaryDTO> customerDiaryDTOs = customerDiaryService.findByInvoiceNo(invoiceNo);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the customerdiarys",
				customerDiaryDTOs);
	}
	
	@GetMapping(value = "getcustomerdiarylinebycustomerdiaryid")
	public ResponseDTO<CustomerDiaryLineDTO> findByCustomerDiaryId(@RequestParam String customerDiaryId) {
		final Long customerDiary = Long.valueOf(customerDiaryId);
		final List<CustomerDiaryLineDTO> customerDiaryLineDTOs = customerDiaryLineService.findByCustomerDiaryId(customerDiary);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the customerdiary lines", customerDiaryLineDTOs);
	}
	
	@GetMapping(value = "getcustomerdiarylinebyproductid")
	public ResponseDTO<CustomerDiaryLineDTO> findByProductId(@RequestParam String productId) {
		final Long product = Long.valueOf(productId);
		final List<CustomerDiaryLineDTO> customerDiaryLineDTOs = customerDiaryLineService.findByProductId(product);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the customerdiary lines", customerDiaryLineDTOs);
	}
	
	@GetMapping(value = "getcustomerdiarylinebyproductcategoryid")
	public ResponseDTO<CustomerDiaryLineDTO> findByProductCategoryId(@RequestParam String productCategoryId) {
		final Long productCategory = Long.valueOf(productCategoryId);
		final List<CustomerDiaryLineDTO> customerDiaryLineDTOs = customerDiaryLineService.findByCustomerDiaryId(productCategory);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the customerdiary lines", customerDiaryLineDTOs);
	}
	
	@GetMapping(value = "getcustomervistbyid")
	public ResponseDTO<CustomerVisitDTO> findcustomervistById(@RequestParam String customerVisitId) {
		final Long customerVisit = Long.valueOf(customerVisitId);
		final CustomerVisitDTO customerVisitDTO = customerVisitService.findByCustomerVisitId(customerVisit);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the customervisit", customerVisitDTO);
	}
	
	@GetMapping(value = "getcustomervistbycustomerdiaryid")
	public ResponseDTO<CustomerVisitDTO> findCustomerVistByCustomerDiaryId(@RequestParam String customerDairyId) {
		final Long customerDairy = Long.valueOf(customerDairyId);
		final  List<CustomerVisitDTO> customerVisitDTOs = customerVisitService.findByCustomerDiaryId(customerDairy);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the customervisit", customerVisitDTOs);
	}
	
	@GetMapping(value = "getcustomervistbycustomerid")
	public ResponseDTO<CustomerVisitDTO> findCustomerVistByDate(@RequestParam String customer_id) {
		final Long customer = Long.valueOf(customer_id);
		final  List<CustomerVisitDTO> customerVisitDTOs = customerVisitService.findByCustomerId(customer);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the customervisit", customerVisitDTOs);
	}
	
	@GetMapping(value = "getcustomervistbydate")
	public ResponseDTO<CustomerVisitDTO> findCustomerVistByDate(@RequestParam Date date) {
		final  List<CustomerVisitDTO> customerVisitDTOs = customerVisitService.findByDate(date);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the customervisit", customerVisitDTOs);
	}
	
	@GetMapping(value = "getcustomervistbytime")
	public ResponseDTO<CustomerVisitDTO> findCustomerVistByDate(@RequestParam Timestamp time) {
		final  List<CustomerVisitDTO> customerVisitDTOs = customerVisitService.findByTime(time);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the customervisit", customerVisitDTOs);
	}
}