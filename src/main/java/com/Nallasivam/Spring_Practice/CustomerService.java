package com.Nallasivam.Spring_Practice;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

		
		private CustomerRepository customerRepo;
		
		public CustomerService(CustomerRepository customerRepo) {
			
			this.customerRepo=customerRepo;
		}
		
		public Customer saveData(Customer customer) {
			
			System.out.println(customer.getId());
			System.out.println(customer.getName());
			System.out.println(customer.getEmail());
			System.out.println(customer.getAadharNumber());
			return customerRepo.save(customer);
			
		}
		
			public Customer getDataOfCustomerById(int id) {
				
						
				return customerRepo.findById(id).orElseThrow(()->new AccountNotFoundException("This id's account is not found"));
			}
		
			public List<Customer> getAllCustomers(){
				
				return (List<Customer>)customerRepo.findAllCustomerIncludingNoAccounts();
			}
			
			
	        public List<Customer> getAllCustomersWithoutLazy(){
				
				return (List<Customer>)customerRepo.findAllCustomerIncludingNoAccountsWithoutLazy();
			}
	
			public List<Customer> getAllCustomersWithName(String name){
				
					return customerRepo.findAllCustomersWithSpecificNames(name);
			}
}
