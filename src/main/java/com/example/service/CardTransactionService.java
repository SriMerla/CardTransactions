package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.example.springjms.Producer;
import com.example.user.Sno;
import com.example.user.User;

@Component
public class CardTransactionService {
    
	@Autowired
	JdbcCardTransactionRepo jdbcCardTransactionRepo;
	
	@Autowired
	User user;
	
	
	@Autowired
	Producer producer;
	
	@Autowired
	Sno sno;
	
	
	
	public void getTransactions() {
		
		//.out.println("getTransactions method invoked");
		List<User> transactionsList = new ArrayList<User>();
		transactionsList = jdbcCardTransactionRepo.findAll();
		transactionsList.forEach(x -> producer.sendMessage("cardTransaction.queue", x.toString()));
		
		//System.out.println("end of getTransactions method");
	}
	
	public int maxSno() {
		System.out.println("maxSno method invoked");
		int sno = jdbcCardTransactionRepo.findsNo();
		
		return sno;
        
		//System.out.println(sno);
		
	}
	
	
	public void saveToDb() {
		
		int sNo = jdbcCardTransactionRepo.findsNo();
		sno.setSno(sNo);
		
		jdbcCardTransactionRepo.insert(sno);
		
		/*
		 * List<User> lastTransaction = new ArrayList<User>(); lastTransaction =
		 * jdbcCardTransactionRepo.findRecord(); lastTransaction.forEach(x ->
		 * System.out.println(x));
		 */
        
        
		/*
		 * String uname[] user.setsNo(.subString()); user.setAmount(msg.substring(15));
		 * receiverUser.setCardNo(msg.substring(6,14));
		 * receiverUser.setTransactionId(msg.substring(0,5));
		 */
		//System.out.println(lastTransaction);
	}
	
	public void getLatestTransactions() {
		
		int previousSno = jdbcCardTransactionRepo.findsNoFromSno();
		int presentSno = jdbcCardTransactionRepo.findsNo();
		int diffNum = presentSno - previousSno;
		if(previousSno < presentSno && diffNum >= 20) {
			
			List<Map<String, Object>> latestTransactionsList = new ArrayList<Map<String, Object>>();
			latestTransactionsList = jdbcCardTransactionRepo.findBySno(diffNum);
			latestTransactionsList.forEach(x -> producer.sendMessage("cardTransaction.queue", x.toString()));
			
			
		}
		else {
			System.out.println("No latest updates");
		}
		
	}
	
   
}
