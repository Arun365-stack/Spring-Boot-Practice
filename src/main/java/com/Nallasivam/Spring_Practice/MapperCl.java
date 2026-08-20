package com.Nallasivam.Spring_Practice;

import org.springframework.stereotype.Component;

@Component
public class MapperCl {
	
		public BankAccount getandGive(AccountRequest accReq) {
			
				BankAccount bankaccount=new BankAccount();
				bankaccount.setAccountNumber(accReq.getAccountNumber());
				bankaccount.setName(accReq.getName());
				
				return bankaccount;
		}

			public AccountResponse getandGivetoClient(BankAccount bankaccount) {
				
				AccountResponse accResp=new AccountResponse();
							accResp.setAccountNumber(bankaccount.getAccountNumber());
							accResp.setName(bankaccount.getName());
					return accResp;
			}
}
