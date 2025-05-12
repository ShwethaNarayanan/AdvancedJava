package com.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.entity.Account;
import com.account.exceptions.CustomExceptions;
import com.account.model.AccountDTO;
import com.account.service.AccountService;
import com.account.utils.AccountFactory;


@RestController
@RequestMapping("/account")
public class AccountController {
	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping("/")
	public String getAccount() {
		return "Account";
	}
	
	@PostMapping("/createaccount")
	public ResponseEntity<String> register(@RequestBody AccountDTO accountDTO) {
		Account account = AccountFactory.create(accountDTO.getAccountType());
		try {
			accountService.saveAccount(account);		
			return new ResponseEntity<>("Account created successfully!", HttpStatus.OK);
		}catch (Exception e) {
			throw new CustomExceptions(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
	}

}
