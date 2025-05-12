package com.account.utils;

import java.math.BigDecimal;
import org.springframework.http.HttpStatus;
import com.account.exceptions.CustomExceptions;

public interface AccountOperations {
	
	public default String deposit(BigDecimal balanceAmt, BigDecimal depositAmt) {
		try{
			balanceAmt.add(depositAmt);
			return "Deposit transaction success!";
		}catch (Exception e) {
			throw new CustomExceptions(HttpStatus.BAD_REQUEST, "Deposit transaction failed!");
		}
	}
	public default String withdraw(BigDecimal balanceAmt, BigDecimal  withdrawalAmt) {
		try{
			balanceAmt.subtract(withdrawalAmt);
			return "Withdrawal transaction success!";
		}catch (Exception e) {
			throw new CustomExceptions(HttpStatus.BAD_REQUEST, "Withdrawal transaction failed!");
		}
	}
	public default String calculateInterest() {
		
		//Calculate interest based on the option selected during account creation 
		// Weekly, Quarterly, Bi-annual and Annual
		return "Success";
		
	}

}
