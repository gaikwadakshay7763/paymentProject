package com.cybage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Account;
import com.cybage.model.CardDetails;
import com.cybage.service.AccountService;



@RestController
 
public class BankServiceController {
	
@Autowired
Account account;
@Autowired
AccountService accountService;


	
 @PostMapping("/authentication")
	public ResponseEntity<Object> AuthenticateCardDetail(@RequestBody CardDetails cardDetails) throws Exception {
	
	 try {
		    accountService.auhorization(cardDetails);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return new ResponseEntity<Object>(cardDetails,HttpStatus.OK) ;

	 //return null;
	 
	 
	
		
	

}
 
 @PostMapping("/addAccount")
 public ResponseEntity<Object> addAccountEntity(@RequestBody Account account,HttpServletRequest request){
	
		return  new ResponseEntity<Object>(accountService.addAccount(account),HttpStatus.OK) ;
}
 
 @GetMapping("/allAccount")
 public ResponseEntity<Object> getAccountEntity(HttpServletResponse response){
	 try {
	 List<Account> list = accountService.getAllAccount();
	 
	 return new ResponseEntity<Object>(list,HttpStatus.OK);
	 }
	 catch(Exception e) {
		 e.printStackTrace();
		 System.out.println("Account Database is empty");
		 
	 }
	 return new ResponseEntity<Object>(HttpStatus.OK);
	 
 }
}

