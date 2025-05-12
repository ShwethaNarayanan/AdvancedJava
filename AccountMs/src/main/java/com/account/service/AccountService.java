package com.account.service;

import com.account.entity.Account;

public interface AccountService {
	
	public String saveAccount(Account acccount);
	public String deleteAccount(String accountnumber);

}
