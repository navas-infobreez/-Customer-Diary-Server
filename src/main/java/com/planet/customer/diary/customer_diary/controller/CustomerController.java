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

import com.planet.customer.diary.customer_diary.model.dto.CustomerDTO;
import com.planet.customer.diary.customer_diary.model.dto.ResponseDTO;
import com.planet.customer.diary.customer_diary.service.CustomerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(value = "getcustomerdetails")
	public ResponseDTO<CustomerDTO> getCustomerDetails(@RequestParam String pid) {
		final Long id = Long.valueOf(pid);
		final CustomerDTO customer = customerService.findByCustomerId(id);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the customer details",
				customer);
	}
	
	@PostMapping(value = "deletecustomer")
	public ResponseDTO<CustomerDTO> deleteCustomer(@RequestParam String pid) {
		final Long id = Long.valueOf(pid);
		customerService.delete(id);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully deleted customer details",
				null);
	}
	
	@PostMapping(value = "getcustomerdetailsbysearchKey")
	public ResponseDTO<CustomerDTO> getCustomerDetailsbySearchKey(@RequestParam String customerSearchKey) {
		final CustomerDTO customer = customerService.findBySearchKey(customerSearchKey);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the customer details",
				customer);
	}
	
	@GetMapping(value = "getallcustomerdetails")
	public ResponseDTO<List<CustomerDTO>> getAllCustomerDetails(){
		final List<CustomerDTO> customer = customerService.findAll();
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the all customer details",
				customer);
	}
	
	@PostMapping(value = "createorupdatecustomer")
	public ResponseDTO<CustomerDTO> createOrUpdateCustomer(@RequestBody final CustomerDTO customerDTO){
		final CustomerDTO customer = customerService.createOrUpdateCustomer(customerDTO);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully updated the customer details",
				customer);
	}
	
	

}