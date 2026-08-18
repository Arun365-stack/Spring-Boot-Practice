package com.Nallasivam.Spring_Practice;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

				private CustomerService customerservice;
				
				public CustomerController (CustomerService customerservice) {
					
					this.customerservice=customerservice;
				}
				
				
				@PostMapping("/customer/post/data")
				public ResponseEntity<Customer> saveCustomerData(@RequestBody Customer customer) {
					
								System.out.println(customer.getId());
								System.out.println(customer.getName());
								System.out.println(customer.getEmail());
								System.out.println(customer.getAadharNumber());
					return ResponseEntity.status(HttpStatus.CREATED).body(customerservice.saveData(customer));
				}
				@GetMapping("/customer/get/data/{id}")
				public ResponseEntity<Customer> getDataOfAccounts(@PathVariable int id){
					
					return ResponseEntity.ok(customerservice.getDataOfCustomerById(id));
				}
				
				@GetMapping("/customer/allaccounts")
				public ResponseEntity<List<Customer>> getAllAccountsCustomer(){
					
					return ResponseEntity.ok(customerservice.getAllCustomers());
				}
				// getAllCustomersWithoutLazy

				@GetMapping("/customer/allaccountsWithoutsLazy")
				public ResponseEntity<List<Customer>> getAllAccountsCustomerNoLazy(){
					
					return ResponseEntity.ok(customerservice.getAllCustomers());
				}
				
				@GetMapping("/customer/all/specificName/{name}")
				public ResponseEntity<List<Customer>> getAllCustomers(@PathVariable String name){
					
							return ResponseEntity.ok(customerservice.getAllCustomersWithName(name));
				}
}
