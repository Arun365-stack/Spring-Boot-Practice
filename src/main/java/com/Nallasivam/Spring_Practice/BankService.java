package com.Nallasivam.Spring_Practice;

import org.springframework.stereotype.Service;

@Service
public class BankService {
		
		private BankAccount bankaccount;
		
		
		public BankService(BankAccount bankaccount) {
				
			this.bankaccount=bankaccount;
				
		}

		
			public void show() {
					
				System.out.println(bankaccount);
					
			}
}
