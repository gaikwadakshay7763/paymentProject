package com.cybage.service;

import java.util.ArrayList;
import java.util.List;

import com.cybage.model.CardDetails;
import com.cybage.model.OtpAuth;
import org.springframework.stereotype.Component;

import com.cybage.model.Account;
@Component
public interface AccountService {

	List<Account> accounts =new ArrayList<Account>() ;



	Account addAccount(Account account);
	
	default  List<Account> getAllAccount(){
		return new ArrayList<>();
	};
	
	boolean auhorization(CardDetails cardDetails);

	void dateComparison(Account user1);

	void generateOTP();

	//void verifyOtp();

	void verifyOtp();
}