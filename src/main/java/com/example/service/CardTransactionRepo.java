package com.example.service;

import java.util.List;

import com.example.user.User;

public interface CardTransactionRepo {
	
	public List<User> findAll();
	
	public int findsNo();

}
