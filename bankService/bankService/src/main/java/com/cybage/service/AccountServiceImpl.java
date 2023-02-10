package com.cybage.service;
import java.io.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import com.cybage.model.OtpAuth;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.databaseConnection.ExcelDataHandler;
import com.cybage.model.Account;
import com.cybage.model.CardDetails;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	ExcelDataHandler excelDataHandler;
	@Autowired
	Account account;
	@Autowired
	CardDetails cardDetails;
	@Autowired
	OtpAuth otpAuth;

	int otp;
	Account user1;

	Logger logger = LogManager.getLogger(getClass());
	List list = new ArrayList<>();

	
	@Override
	public Account addAccount( Account account) {
		
		accounts.add(account);
		try {
			list = excelDataHandler.readData();


			excelDataHandler.appendData(accounts);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("Account added successfully" + account);


		return account;

	}

	@Override
	public List<Account> getAllAccount() {
		
		//List list = new ArrayList<>();
		try {
			 list = excelDataHandler.readData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("Displaying the list of the accounts");
		return new ArrayList<>(list);
	}

	@Override
	public boolean auhorization( CardDetails cardDetails) {
		// TODO Auto-generated method stub
		HashMap<String, Account> cardData = new HashMap<>();

		String date = LocalDate.now().toString();
		try {
		//List<Account> accountData = excelDataHandler.readData();
//		for (Account account : accountData) {
//
//			cardData.put(this.cardDetails.getCardNumber(), account);
//		}
			List<Account> accountData = excelDataHandler.readData();
		List<Account> user =accountData.stream().filter( account -> account.cardDetails.getCardNumber().equals(cardDetails.getCardNumber())).collect(Collectors.toList());
		     user1 = user.get(0);
		if(!(!(cardDetails.getCardHoldersName() == user1.getAccountHolderName()) && !(cardDetails.getCvv() == user1.cardDetails.getCvv()))) {
			System.out.println(user1.cardDetails.getCardExpirDate());

			dateComparison(user1);

			//if((((user1.cardDetails.getCardExpirDate().compareTo(LocalDateTime.now())< 0)||(LocalDate.now().toString().compareTo(user1.cardDetails.getCardExpirDate().toString())==0)))) {

				System.out.println("Card is authorize");

				logger.info("The card authorize " + cardDetails.getCardNumber());

				user1.cardDetails.setCharge(cardDetails.getCharge());

			excelDataHandler.updateAccount(user1);

				 	generateOTP();

			}
		else{
			System.out.println("Card is expired");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
		   //return null;
	}
@Override
	public void dateComparison(Account user1) {

		//SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");

		Date cardDate = user1.cardDetails.getCardExpirDate();

		//Date currentDate = new Date();
		if (cardDate.before(new Date())){
			System.out.println("The card is expired");
			logger.warn("The card is expired");
		}else{
			System.out.println("the card is authorized");
			logger.info("Card is Authorized"+ user1.getAccountHolderName());
		}

	}
@Override
	public void generateOTP(){


		Random number = new Random();

		otp = number.nextInt(10000);

		System.out.println(otp);
		  otpAuth.setOtp(otp);

		 verifyOtp();
//
//		File newFile = new File("otpStore.txt");
//
//		try{
//			FileWriter otpWrite = new FileWriter("otpStore.txt");
//
//			otpWrite.write(otp);
//
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}



}

//	@Override
//	public void verifyOtp() {
//
//	}

	@Override
	public void verifyOtp( ) {
      if (otp==otpAuth.getOtp()){

		  logger.info("payment can be initiated");

		  paymentInitiation(user1);




	  }
	}

	public boolean paymentInitiation(Account user1){
		int accountBalance = user1.getAccountBalance();
		logger.info("payment is processing");

		accountBalance = accountBalance - user1.cardDetails.getCharge();

		user1.setAccountBalance(accountBalance);

		excelDataHandler.updateAccount(user1);



		return true;
	}

//	@Override
//public void verifyOtp(Account otp){
//
//		//if(otp .equals (account.getAuthOtp())){
//
//
//
//
//
//}



}
