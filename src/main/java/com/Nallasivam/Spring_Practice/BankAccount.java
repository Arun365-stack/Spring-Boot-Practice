package com.Nallasivam.Spring_Practice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankAccount {


		@Id
		private int id;
		private String name;
		private long accountNumber;
		private double balance;




		public BankAccount(int id, String name, long accountNumber, double balance) {
			super();
			this.id = id;
			this.name = name;
			this.accountNumber = accountNumber;
			this.balance = balance;
		}



		public BankAccount() {
			super();
		}



		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(long accountNumber) {
			this.accountNumber = accountNumber;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}



}
