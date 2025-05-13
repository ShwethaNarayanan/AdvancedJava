package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.dao.CustomerRepository;
import com.customer.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository; 
	
	@Autowired
	protected CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public String save(Customer customer) {
		
		try {
			customerRepository.save(customer);
			return "Success";
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		
	}

	
}
