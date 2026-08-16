package com.Nallasivam.Spring_Practice;

import java.util.ArrayList;
import java.util.List;

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
			
			public ArrayList<BankAccount> getAllData() {
				
				return (ArrayList<BankAccount>) accountRepo.findAll();
			}
			
			public String deleteDatas(int id) {
				
				accountRepo.deleteById(id);
				
				return "deleted";
		}
			
			public BankAccount findNames(String text) {
				
				
					return accountRepo.findByName(text);
			}

			public List<BankAccount>findAllSameNames(String text){
				
					return accountRepo.findByNameContaining(text);
			}
			
			public List<BankAccount> findNameAndBalance(String text,double balance){
					
				
					return (List<BankAccount>) accountRepo.findByNameAndBalanceGreaterThan(text, balance);
			}
			
			public List<BankAccount> findManyRichAccounts(double balance){
				
					return (List<BankAccount>) accountRepo.findRichAccounts(balance);
			}
			
}
