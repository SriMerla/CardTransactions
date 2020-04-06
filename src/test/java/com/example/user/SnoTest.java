package com.example.user;

import com.example.user.Sno;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SnoTest {
	
	Sno sNo;
	int sno;
	
	
	@BeforeEach
	void init() {
		sNo = new Sno();

		sNo.sno = sno;
	}
	
	

	@Test
	void setSnotest() {
		sNo.setSno(10);
		assertTrue(sNo.getSno() == 10);
		
	}
	
	@Test
	void getSnotest() {
	   
		sNo.setSno(10);
		assertTrue(sNo.getSno() == 10);
		
	}
	
	@Test
	void toStringTest() {
		sNo.toString();
		
	}


}
