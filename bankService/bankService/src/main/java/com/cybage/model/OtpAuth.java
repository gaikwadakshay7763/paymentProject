package com.cybage.model;

import org.springframework.stereotype.Component;

@Component
public class OtpAuth {

    private int otp;


    public OtpAuth(){
        super();
    }

    public OtpAuth(int otp) {
        super();
        this.otp = otp;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }


//    @Override
//    public String toString() {
//        return "OtpAuth{" +
//                "otpAuth=" + otp +
//                '}';
//    }
}
