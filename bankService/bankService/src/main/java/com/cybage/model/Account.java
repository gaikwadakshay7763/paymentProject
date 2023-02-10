package com.cybage.model;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component

public class Account {
	@NonNull
	private String accountNumber ;
	@NonNull
	private String accountHolderName;
	@NonNull
	private int accountBalance;
	@NonNull
	public CardDetails cardDetails;
	//@Nullable
	//public OtpAuth otpAuth;
//	private String cardNumber ;
//	private String cardHoldersName ;
//	private Date cardExpirDate;
//	private int cvv;
	


//	public String getCardHoldersName() {
//		return cardHoldersName;
//	}
//
//	public void setCardHoldersName(String cardHoldersName) {
//		this.cardHoldersName = cardHoldersName;
//	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String accountNumber, String accountHolderName,int accountBalance, CardDetails cardDetails) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
		this.cardDetails = cardDetails;
	}

//	public Account(String accountNumber, String accountHolderName, CardDetails cardDetails, OtpAuth otpAuth) {
//		super();
//		this.accountNumber = accountNumber;
//		this.accountHolderName = accountHolderName;
//		this.cardDetails = cardDetails;
//		this.otpAuth = otpAuth;
//	}

	//	public Account(String accountNumber, String accountHolderName, String cardNumber, String cardHoldersName,
//			Date cardExpirDate, int cvv) {
//		super();
//		this.accountNumber = accountNumber;
//		this.accountHolderName = accountHolderName;
//		this.cardDetails = cardDetails;

//		this.cardNumber = cardNumber;
//		this.cardHoldersName = cardHoldersName;
//		this.cardExpirDate = cardExpirDate;
//		this.cvv = cvv;
//	}

//	public Account(String accountNumber, String accountHolderName, CardDetails cardDetails, int otpAuth) {
//		this.accountNumber = accountNumber;
//		this.accountHolderName = accountHolderName;
//		this.cardDetails = cardDetails;
//		this.otpAuth = otpAuth;
//	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
//	public String getCardNumber() {
//		return cardNumber;
//	}
//
//	public void setCardNumber(String cardNumber) {
//		this.cardNumber = cardNumber;
//	}
//
//	public Date getCardExpirDate() {
//		return cardExpirDate;
//	}
//
//	public void setCardExpirDate(Date date) {
//		this.cardExpirDate = date;
//	}
//
//	public int getCvv() {
//		return cvv;
//	}
//
//	public void setCvv(int cvv) {
//		this.cvv = cvv;
//	}


	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public CardDetails getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(CardDetails cardDetails) {
		this.cardDetails = cardDetails;
	}

//	public OtpAuth getAuthOtp() {
//		return otpAuth;
//	}
//
//	public void setAuthOtp(OtpAuth otpAuth) {
//		this.otpAuth = otpAuth;
//	}

	@Override
	public String toString() {
		return "Account{" +
				"accountNumber='" + accountNumber + '\'' +
				", accountHolderName='" + accountHolderName + '\'' +
				", accountBalance=" + accountBalance +
				", cardDetails=" + cardDetails +
				'}';
	}
//	@Override
//	public String toString() {
//		return "Account{" +
//				"accountNumber='" + accountNumber + '\'' +
//				", accountHolderName='" + accountHolderName + '\'' +
//				", cardDetails=" + cardDetails +
//				", otpAuth=" + otpAuth +
//				'}';
//	}
}
