package com.Nallasivam.Spring_Practice;

import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	
			public boolean saveData(AccountRequest accReq) {
				
				
				System.out.println(accReq.getAccountNumber());
			    System.out.println(accReq.getName());
			    System.out.println(accReq.getBalance());
				
				if (accReq.getBalance()<=0) {
					
					return false;
				}
				else 
					return true;
			}
	

}
