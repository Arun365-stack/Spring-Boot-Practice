package com.Nallasivam.Spring_Practice;

public class AccountResponse {

		private  long accountNumber;
		private String name;
		private double balance;


		public AccountResponse(long accountNumber,String name,double balance) {

			this.accountNumber=accountNumber;
			this.name=name;
			this.balance=balance;
		}


		public AccountResponse() {
			// TODO Auto-generated constructor stub
		}


		public long getAccountNumber() {
			return accountNumber;
		}




		public String getName() {
			return name;
		}




		public double getBalance() {
			System.out.println("getBalance() called");
			return balance;
		}


		public void setAccountNumber(long accountNumber) {
			this.accountNumber = accountNumber;
		}


		public void setName(String name) {
			this.name = name;
		}


		public void setBalance(double balance) {
			this.balance = balance;
		}

		

	/* public String toString() {

			return "account number" +accountNumber+ "balance " + balance +"name"+ name;
	}*/

}
