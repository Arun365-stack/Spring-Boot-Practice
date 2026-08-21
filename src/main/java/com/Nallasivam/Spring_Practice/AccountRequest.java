package com.Nallasivam.Spring_Practice;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class AccountRequest {

	@NotBlank(message="name cannot be empty")
	private String name;
	
	private long accountNumber;
// private double balance;

	public String getName() {

			return name;
	}

	public void setName(String name) {

		this.name=name;
	}

	public long getAccountNumber() {

		return accountNumber;

	}
	public void setAccountNumber(long accountNumber) {

		this.accountNumber=accountNumber;
	}

/*	public double getBalance() {

		return balance;
	}

	public void setBalance(double balance) {
		this.balance=balance;
	}  */
}
