package com.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springjms.Producer;
import com.example.user.Sno;
import com.example.user.User;


//@SpringBootTest
class CardTransactionServiceTest {
	
	CardTransactionService cardTransactionService;
	JdbcCardTransactionRepo jdbcCardTransactionRepoMock = Mockito.mock(JdbcCardTransactionRepo.class);
	Producer producer = Mockito.mock(Producer.class);
	User user = Mockito.mock(User.class);
	Sno sno = Mockito.mock(Sno.class);
	
	@BeforeEach
	void init() {

		 cardTransactionService = new CardTransactionService();
		 cardTransactionService.jdbcCardTransactionRepo = jdbcCardTransactionRepoMock;
		 cardTransactionService.producer = producer;
		 cardTransactionService.sno =sno;
		//  cardTransactionService.user = user;
	}

	@Test
	void test() {
;		System.out.println("***** From cardTransactionServiceTest *****" );
	}
	
	
	
	@Test
	void maxSnoTest() {
		System.out.println("***** From maxSnoTest *****" );
		int maxNo = 100;
		when(jdbcCardTransactionRepoMock.findsNo()).thenReturn(maxNo);
		int no = cardTransactionService.maxSno();
		assertEquals(100, no );
	}
	
	@Test
	void getTiransactionsTest() {
		System.out.println("***** From getTransactionsTest *****" );
		List<User> list = new ArrayList<User>();
           	
        	list.add(user);
        	
		
		when(jdbcCardTransactionRepoMock.findAll()).thenReturn(list);
		cardTransactionService.getTransactions();
		//assertEquals(100, no );
	}
	
	@Test
	void getLatestTransactionsTest() {
		System.out.println("***** From getLatestTransactionsTest *****" );
		when(jdbcCardTransactionRepoMock.findsNoFromSno()).thenReturn(50);
		when(jdbcCardTransactionRepoMock.findsNo()).thenReturn(100);
		cardTransactionService.getLatestTransactions();
		//when(jdbcCardTransaction)
		
		
	}
	
	@Test
	void saveToDboTest() {
		System.out.println("****** From saveToDbTest method");
		
		 when(jdbcCardTransactionRepoMock.findsNo()).thenReturn(50);
		
		cardTransactionService.saveToDb();
	    
		
	}

	
	

}
