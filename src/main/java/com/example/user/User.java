package com.example.user;

import org.springframework.stereotype.Component;

@Component
public class User {

	private int sNo;

	
	private int cardNo;
	private int amount;

	public User() {

	}

	public User(int cardNo, int amount, int sNo) {
		super();
		this.sNo = sNo;
		this.cardNo = cardNo;
		this.amount = amount;
	}
	
	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}


	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount; 
	}

	@Override
	public String toString() {
		return "User [sNo=" + sNo + ", cardNo=" + cardNo + ", amount=" + amount + "]";
	}
	
	
	

}
