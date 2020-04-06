package com.example.service;

import java.util.List;
import java.util.Map;

import com.example.user.Sno;
import com.example.user.User;

public interface CardTransactionRepo {
	
	public void save(User user);
	//public void insert(User user);
	public void insert(Sno sno);

   // public void insert(int sno);

    public void delete(String sno);
    
    public List<User> findRecord();
    
    public List<Map<String, Object>> findBySno(int sno);	
	public List<User> findAll();
	
	public int findsNo();
	public int findsNoFromSno();

}
