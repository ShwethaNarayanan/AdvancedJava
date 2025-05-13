package com.bank.entities;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankInfo {
		
		@NotEmpty
		private String bankname;
		@NotEmpty
		private int account;
		@NotEmpty
		private int ssn;
		@NotEmpty
	    private int accountid;
	

}
