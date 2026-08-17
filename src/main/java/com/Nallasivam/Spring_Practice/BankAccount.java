package com.Nallasivam.Spring_Practice;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BankAccount {


		@Id
		private int id;
		private String name;
		private long accountNumber;
		private double balance;

		@ManyToOne 
		@JoinColumn(name="customer_id")
		@JsonIgnore
		private Customer customer;  



		public BankAccount(int id, String name, long accountNumber, double balance,Customer customer) {
			super();
			this.id = id;
			this.name = name;
			this.accountNumber = accountNumber;
			this.balance = balance;
			this.customer=customer;
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
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer=customer;
		}


}
