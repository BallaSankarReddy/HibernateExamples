package com.flipkart.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart.expections.CustomerExpection;
import com.flipkart.model.Customer;
import com.flipkart.repository.CustomerRepo;
import com.flipkart.repository.ElectronicsRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private ElectronicsRepo electronicsRepo;

	public Customer customerCreation(Customer customer) throws CustomerExpection {

		if (customer.getCustomerId() != null) {

			customer = customerRepo.save(customer);
		}

		return customer;
	}

	public List<Customer> getCustomerList() {

		List<Customer> listOfCustomer= customerRepo.findAll();
		listOfCustomer.stream().sorted(Comparator.comparing(Customer::getCustomerName)
													.thenComparing(Customer::getCustomerId)).collect(Collectors.toList());
			
		
	
		
		return listOfCustomer; 
	}

	public Customer findCustomer(Integer customerId) {

		return customerRepo.findById(customerId).map(r -> r).orElse(null);
	}
}
