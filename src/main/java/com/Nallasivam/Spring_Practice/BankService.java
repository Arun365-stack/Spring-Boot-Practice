package com.Nallasivam.Spring_Practice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
			
			public List<BankAccount> findBalnceWithSomeConditions(double minbalance,double maxbalance){
				
					return (List<BankAccount>) accountRepo.findByBalance(minbalance,maxbalance);
			}
			
			
			public List<BankAccount> findByBalanceNameDesc(String name,double minbalance,double maxbalance){
				
				System.out.println(name+ " " +minbalance+ " " +maxbalance);
				
				return (List<BankAccount>) accountRepo.findByBalanceAndNameContaining(name,minbalance,maxbalance);
		}
			
			public List<BankAccount> findCustomerAccounts(String name){
				
				return (List<BankAccount>) accountRepo.findAccountsByCustomerName(name);
			}
			
			public List<BankAccount> findParticularCustomerBalanceLessThan(int id,double balance){
				
								System.out.println(id+ " " +balance);
									
				return (List<BankAccount>) accountRepo.findParticularCustomerWhoisHavingBalanceLessThan(id,balance);
			}
			@Transactional
			public String findBankAccountAndTransaction(int fromId,int toId,double amount) {
				
				BankAccount fromAccount=accountRepo.findById(fromId).orElseThrow();
				BankAccount toAccount=accountRepo.findById(toId).orElseThrow();
				
					fromAccount.setBalance(fromAccount.getBalance()-amount);
					toAccount.setBalance(toAccount.getBalance()+amount);
				
					return "Transaction done";
			}
}
