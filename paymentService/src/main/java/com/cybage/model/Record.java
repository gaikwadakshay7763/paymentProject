package com.cybage.model;

import org.springframework.stereotype.Component;

import javax.smartcardio.Card;

@Component
public class Record {
    //Accounts to remove
    private int transactionId;
    //public Account account;
    public Customer customer;
    public Merchant merchant;
    public CardDetails cardDetails;

    public Record(int transactionId, CardDetails cardDetails, Merchant merchant, Customer customer){
        super();
    }

    public Record(int transactionId, Customer customer, Merchant merchant, CardDetails cardDetails) {
        this.transactionId = transactionId;
        this.customer = customer;
        this.merchant = merchant;
        this.cardDetails = cardDetails;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public CardDetails getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(CardDetails cardDetails) {
        this.cardDetails = cardDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    @Override
    public String toString() {
        return "Record{" +
                "transactionId=" + transactionId +
                ", cardDetails=" + cardDetails +
                ", customer=" + customer +
                ", merchant=" + merchant +
                '}';
    }
}
