package com.Nallasivam.Spring_Practice;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

	
		AccountRepository accountRepo;
		
		public AccountService(AccountRepository accountRepo) {
			
			this.accountRepo=accountRepo;
		}

		/*	public boolean saveData(AccountRequest accReq) {


				System.out.println(accReq.getAccountNumber());
			    System.out.println(accReq.getName());

			    System.out.println(accReq.getBalance());

				if (accReq.getBalance()<=0) {

					return false;
				}
				else
					return true;
			}


			    } */

			public AccountResponse createAccount(AccountRequest accReq) {

							if(accReq.getName()==null || accReq.getName().isEmpty()) {

									throw new InvalidArgumentException("invalid name");

							}
							else if(accReq.getAccountNumber()<=0) {

									throw new AccountNotFoundException("invalid account number");
							}

							double Startingbalance=0.0;

						return new AccountResponse(accReq.getAccountNumber(),accReq.getName(),Startingbalance);
			}


			public void saveData(BankAccount bankAccount) {
					System.out.println(bankAccount.getName());
				accountRepo.save(bankAccount);
				
			}
			
			
}
