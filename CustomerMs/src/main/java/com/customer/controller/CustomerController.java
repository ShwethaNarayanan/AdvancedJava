package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.dto.CustomerDTO;
import com.customer.entities.Customer;
import com.customer.entities.Customer.CustomerBuilder;
import com.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/")
	public String getCustomer() {
		return "Customer";
	}

	@PostMapping("/createcustomer")
	public String createcustomer(@RequestBody CustomerDTO customerDTO) {

		CustomerBuilder customerBuilder = new CustomerBuilder(customerDTO.getFirstname(), customerDTO.getLastname(),
				customerDTO.getEmail(), customerDTO.getUsername());
		if (customerDTO.getMiddlename() != null) {
			customerBuilder.setMiddlename(customerDTO.getMiddlename());
		}

		Customer customer = customerBuilder.build();
		customerService.save(customer);
		return "Success";
	}

//		@PostMapping("/usercreateaccount")
//		public ResponseEntity<String> register(@RequestBody ) {
//
//				customerService.save(account);		
//
//		}

}
