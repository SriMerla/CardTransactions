package com.example.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
       
	User user;
	
	
		@BeforeEach
		void init() {
			user = new User();
			
		}
		
		@Test
		void setsNoTest() {
			user.setsNo(10);
			assertTrue(user.getsNo() == 10);
			
		}
		
		@Test
		void setCardNoTest() {
			user.setCardNo(11111111);
			assertTrue(user.getCardNo() == 11111111);
			
		}
		
		@Test
		void setAmountTest() {
			user.setAmount(10000);
			assertTrue(user.getAmount() == 10000);
			
		}
		@Test
		void getsNoTest() {
			user.setsNo(10);
			assertTrue(user.getsNo() == 10);
			
		}
		
		@Test
		void getCardNoTest() {
			user.setCardNo(11111111);
			assertTrue(user.getCardNo() == 11111111);
			
		}
		
		@Test
		void getAmountTest() {
			user.setsNo(10000);
			assertTrue(user.getsNo() == 10000);
			
		}
		
		@Test
		void toStringTest() {
			user.toString();
		}
			

		
		
			
		
		
}	
		

