package com.cybage.model;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class CardDetails {
    public  String cardNumber ;
    private String cardHoldersName ;
    private Date cardExpirDate;
    private int cvv;
    private int charge;

    public CardDetails(){
        super();
    }
    public CardDetails(String cardNumber, String cardHoldersName, Date cardExpirDate, int cvv, int charge) {
        this.cardNumber = cardNumber;
        this.cardHoldersName = cardHoldersName;
        this.cardExpirDate = cardExpirDate;
        this.cvv = cvv;
        this.charge = charge;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHoldersName() {
        return cardHoldersName;
    }

    public void setCardHoldersName(String cardHoldersName) {
        this.cardHoldersName = cardHoldersName;
    }

    public Date getCardExpirDate() {
        return cardExpirDate;
    }

    public void setCardExpirDate(Date cardExpirDate) {
        this.cardExpirDate = cardExpirDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    @Override
    public String toString() {
        return "CardDetails{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardHoldersName='" + cardHoldersName + '\'' +
                ", cardExpirDate=" + cardExpirDate +
                ", cvv=" + cvv +
                ", charge=" + charge +
                '}';
    }
}
