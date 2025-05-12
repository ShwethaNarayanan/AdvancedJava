package com.account.utils;

import org.springframework.http.HttpStatus;

import com.account.entity.Account;
import com.account.exceptions.CustomExceptions;
import com.account.model.CheckingAccount;
import com.account.model.SavingsAccount;

public class AccountFactory {
	
	public static Account create(Character accountType) {
		
		switch(accountType) {
		case Constants.CHECKING -> {
			Account checking_account = new CheckingAccount();
			checking_account.setInterestRate(Constants.checking_interestRate);
			return checking_account;
		}
		case Constants.SAVINGS -> {
			Account savings_account = new SavingsAccount();
			savings_account.setInterestRate(Constants.saving_interestRate);
			return savings_account;
		}
		default -> {
			throw new CustomExceptions(HttpStatus.BAD_REQUEST, "This Account type is not currently supported");
		}
		}

	}

}
