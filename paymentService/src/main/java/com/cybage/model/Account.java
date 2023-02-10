package com.cybage.model;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class Account {

    @NonNull
    private String accountNumber ;
    @NonNull
    private String accountHolderName;
    @NonNull
    private int accountBalance;
    //@NonNull
    //public CardDetails cardDetails;


    public Account() {

        super();
    }

    public Account( String accountNumber, String accountHolderName, int accountBalance,  CardDetails cardDetails) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
       // this.cardDetails = cardDetails;
    }



    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber( String accountNumber) {
        this.accountNumber = accountNumber;
    }


    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName( String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }


//    public CardDetails getCardDetails() {
//        return cardDetails;
//    }
//
//    public void setCardDetails( CardDetails cardDetails) {
//        this.cardDetails = cardDetails;
//    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountBalance=" + accountBalance +
                //", cardDetails=" + cardDetails +
                '}';
    }
}
