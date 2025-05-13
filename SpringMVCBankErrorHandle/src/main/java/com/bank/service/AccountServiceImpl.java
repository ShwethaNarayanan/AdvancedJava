package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.AccountDao;
import com.bank.entities.BankInfo;
import com.bank.entities.ContactInfo;
import com.bank.entities.PersonalInfo;
import com.bank.exceptions.CustomExceptions;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountdao;
	
	@Override
	public int savePersonalInfo(PersonalInfo personalinfo) throws CustomExceptions{
		try {
			return accountdao.savePersonalInfo(personalinfo);
		}catch(CustomExceptions e) {
			throw new CustomExceptions(e.getMessage());
		}		
	}

	@Override
	public int saveBankInfo(BankInfo bankinfo) throws CustomExceptions{
		
		try {
			return accountdao.saveBankInfo(bankinfo);
			
		}catch(CustomExceptions e) {
			throw new CustomExceptions(e.getMessage());
		}
	
	}



	@Override
	public int saveContactInfo(ContactInfo contactinfo) throws CustomExceptions{
		try {
			return accountdao.saveContactInfo(contactinfo);
			
		}catch(CustomExceptions e) {
			throw new CustomExceptions(e.getMessage());
		}
	}

}
