package com.example.user;

import org.springframework.stereotype.Component;

@Component
public class Sno {

	 int sno;

	public Sno(int sno) {
		super();
		this.sno = sno;
	}

	public Sno() {

	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	@Override
	public String toString() {
		return "Sno [sno=" + sno + "]";
	}

}
