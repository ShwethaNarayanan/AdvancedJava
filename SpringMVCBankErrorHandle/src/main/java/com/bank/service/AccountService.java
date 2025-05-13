package com.bank.service;

import com.bank.entities.BankInfo;
import com.bank.entities.ContactInfo;
import com.bank.entities.PersonalInfo;

public interface AccountService {
	
	public int savePersonalInfo(PersonalInfo personalinfo);
	
	public int saveContactInfo(ContactInfo contactinfo);
	
	public int saveBankInfo(BankInfo bankinfo);

}
