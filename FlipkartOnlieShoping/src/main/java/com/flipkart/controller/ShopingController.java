package com.flipkart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.expections.CustomerExpection;
import com.flipkart.model.Customer;
import com.flipkart.repository.CustomerRepo;
import com.flipkart.repository.ElectronicsRepo;
import com.flipkart.service.CustomerService;

@RestController
@RequestMapping("/Shoping/online")
public class ShopingController {
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private ElectronicsRepo electronicsRepo;
	@Autowired
	private CustomerService customerService;

	@GetMapping("/hi")
	public String onlieShoping() {
		return "Hello";
	}

	@PostMapping(path="/customer/user",consumes = "application/json", produces = "application/xml")
	
	public Customer saveCustomer(@RequestBody Customer customer) throws CustomerExpection {

		return customerService.customerCreation(customer);
	}
	//,produces = {"application/json", "application/xml"}
	@GetMapping(path = "/getAll",produces = "application/xml" )
			
			public List<Customer> getListOfCustomer() {
		return customerService.getCustomerList();
	}
	
	@GetMapping("/customer/user/fcust/{custId}")
	public Customer customerDetails(@PathVariable Integer custId){
					
		return customerService.findCustomer(custId);
	}

}
