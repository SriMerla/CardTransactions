package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.user.User;

@Repository
public class JdbcCardTransactionRepo implements CardTransactionRepo {
     
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<User> findAll() {
		return jdbcTemplate.query("SELECT * FROM CARDTRANSACTIONS",
				((rs, rowNum) -> new User(rs.getInt("SNO"),
						                  rs.getInt("CARD"),
						                  rs.getInt("AMOUNT")
						))
				);
	}

	@Override
	public int findsNo() {
		return jdbcTemplate.query("SELECT MAX(SNO) FROM CARDTRANSACTIONS", Integer.class);
		//return jdbcTemplate.getMaxRows();
	}

	

}
