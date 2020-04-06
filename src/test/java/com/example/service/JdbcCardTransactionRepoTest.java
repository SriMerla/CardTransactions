package com.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.user.Sno;
import com.example.user.User;

class JdbcCardTransactionRepoTest extends JdbcCardTransactionRepo {
	JdbcCardTransactionRepo jdbcCardTransactionRepo;
	JdbcTemplate jdbcTemplate = Mockito.mock(JdbcTemplate.class);
	
	@BeforeEach
	void init() {
		 jdbcCardTransactionRepo = new JdbcCardTransactionRepo();
		 jdbcCardTransactionRepo.jdbcTemplate = jdbcTemplate;
	}

	@Test
	void test() {
		System.out.println("****** From JdbcCardTransactionRepoTest");
	}
	
	
	@Test
	void findAlloTest() {
		System.out.println("****** From findAllTest method");
	   List<User> list = new ArrayList<User>();
		when(jdbcTemplate.query("SELECT * FROM CARDTRANSACTIONS",
				((rs, rowNum) -> new User(rs.getInt("SNO"),
						                  rs.getInt("CARD"),
						                  rs.getInt("AMOUNT")
						)))).thenReturn(list);
		assertEquals(list, jdbcCardTransactionRepo.findAll());
		
	}
	
	@Test
	void findsNoTest() {
		System.out.println("****** From findsNoTest method");
	   
		when(jdbcTemplate.queryForObject("SELECT MAX(SNO) FROM CARDTRANSACTIONS", Integer.class)).thenReturn(100);
		assertEquals(100, jdbcCardTransactionRepo.findsNo());
		
	}
	
	@Test
	void findRecordTest() {
		System.out.println("****** From findRecordTest method");
		List<User> list = new ArrayList<User>();
		when(jdbcTemplate.query("SELECT * FROM CARDTRANSACTIONS WHERE SNO=(SELECT MAX(SNO) FROM CARDTRANSACTIONS)", 
				((rs, rowNum) -> new User(rs.getInt("SNO"),
		                  rs.getInt("CARD"),
		                  rs.getInt("AMOUNT")
		)))).thenReturn(list);
		assertEquals(list, jdbcCardTransactionRepo.findRecord());
	    
		
	}
	
	@Test
	void findBySnoTest() {
		System.out.println("****** From findBySnoTest method");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int sno = 50;
		when(jdbcTemplate.queryForList("SELECT * FROM CARDTRANSACTIONS WHERE SNO > ?", sno)).thenReturn(list);
		assertEquals(list, jdbcCardTransactionRepo.findBySno(sno));
	    
		
	}
	
	@Test
	void findsNoFromSnoTest() {
		System.out.println("****** From findsNoFromSnoTest method");
		//List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int sno = 50;
		when(jdbcTemplate.queryForObject("SELECT MAX(SNO) FROM SNO", Integer.class)).thenReturn(sno);
		assertEquals(50, jdbcCardTransactionRepo.findsNoFromSno());
	    
		
	}
	
	

}
