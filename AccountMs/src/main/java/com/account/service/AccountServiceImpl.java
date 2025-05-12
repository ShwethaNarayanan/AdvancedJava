package com.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import com.account.dao.AccountRepository;
import com.account.entity.Account;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public String saveAccount(Account account) {
		try {
			accountRepository.save(account);
			return "Success";
		}catch (Exception e) {
			throw new DataAccessResourceFailureException("Data access Exception while saving!");
		}
	}

	@Override
	public String deleteAccount(String accountnumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
