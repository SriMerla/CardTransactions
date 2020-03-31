package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.example.springjms.Producer;
import com.example.user.User;

@Component
public class CardTransactionService {
    
	@Autowired
	JdbcCardTransactionRepo jdbcCardTransactionRepo;
	
	@Autowired
	User user;
	
	
	@Autowired
	Producer producer;
	
	
	
	public void getTransactions() {
		
		System.out.println("getTransactions method invoked");
		List<User> transactionsList = new ArrayList<User>();
		transactionsList = jdbcCardTransactionRepo.findAll();
		transactionsList.forEach(x -> producer.sendMessage("cardTransaction.queue", x.toString()));
		
		System.out.println("end of getTransactions method");
	}
	
	public void maxSno() {
		System.out.println("maxSno method invoked");
		int sno = jdbcCardTransactionRepo.findsNo();
		System.out.println(sno);
	}
	
   
}
