package com.Nallasivam.Spring_Practice;

import org.springframework.stereotype.Service;

@Service
public class BankService {

	AccountRepository accountRepo;
	
	public BankService(AccountRepository accountRepo) {
		
		this.accountRepo=accountRepo;
	}
			
			public BankAccount getDData(int id) {
				
					return accountRepo.findById(id).orElseThrow(()->new AccountNotFoundException("This id's account is not found"));
			}
}
