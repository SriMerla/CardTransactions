package com.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.user.Sno;
import com.example.user.User;

@Repository
public class JdbcCardTransactionRepo implements CardTransactionRepo {
     
	@Autowired
	 JdbcTemplate jdbcTemplate;
	
	
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
		 int num = jdbcTemplate.queryForObject("SELECT MAX(SNO) FROM CARDTRANSACTIONS", Integer.class);
		 return num;
		//return jdbcTemplate.getMaxRows();
	}

	@Override
	public void save(User user) {
		 final String sql_insert = "insert into CARDS(SNO, CARD, AMOUNT ) values(?, ?, ?)";
	        Object[] userParam = new Object[]{user.getsNo(), user.getCardNo(), user.getAmount()};
	        jdbcTemplate.update(sql_insert, userParam);
		
	}

	@Override
	public void insert(Sno sno) {
		jdbcTemplate.update("INSERT INTO SNO(SNO) values(?)", new Object[] {sno.getSno()});
		
	}

	@Override
	public void delete(String sno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> findBySno(int sno) {
		/*
		 * return jdbcTemplate.query("SELECT * FROM CARDTRANSACTIONS", ((rs, rowNum) ->
		 * new User(rs.getInt("SNO"), rs.getInt("CARD"), rs.getInt("AMOUNT") )) );
		 */
		return jdbcTemplate.queryForList("SELECT * FROM CARDTRANSACTIONS WHERE SNO > ?", sno);
	}


	@Override
	public List<User> findRecord() {
		 return jdbcTemplate.query("SELECT * FROM CARDTRANSACTIONS WHERE SNO=(SELECT MAX(SNO) FROM CARDTRANSACTIONS)", 
				((rs, rowNum) -> new User(rs.getInt("SNO"),
		                  rs.getInt("CARD"),
		                  rs.getInt("AMOUNT")
		))
	
				 );
		
	}

	@Override
	public int findsNoFromSno() {
		return jdbcTemplate.queryForObject("SELECT MAX(SNO) FROM SNO", Integer.class);
	}

	

}
