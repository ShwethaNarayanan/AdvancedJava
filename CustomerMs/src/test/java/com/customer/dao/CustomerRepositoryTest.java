package com.customer.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.customer.entities.Customer;
import com.customer.entities.Customer.CustomerBuilder;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void CustomerRepository_Save_ReturnSaveCustomer() {
		//Arrange
		Customer customer = new CustomerBuilder("Paramahamsa", "Yogananda","pyogananda@gmail.com", "yoga").build();
		//Act
		Customer savedCustomer = customerRepository.save(customer);
		//Assert
		Assertions.assertThat(savedCustomer).isNotNull();
		Assertions.assertThat(savedCustomer.getFirstname()).isNotEmpty();
	}
}
