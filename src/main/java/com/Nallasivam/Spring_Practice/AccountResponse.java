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


	/* public String toString() {

			return "account number" +accountNumber+ "balance " + balance +"name"+ name;
	}*/

}
