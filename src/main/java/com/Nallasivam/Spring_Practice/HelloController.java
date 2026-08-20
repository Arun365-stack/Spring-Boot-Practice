package com.Nallasivam.Spring_Practice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

			private AccountService accService;

			private BankService bankservice;

			public HelloController(AccountService accService,BankService bankservice) {

				this.accService=accService;
				this.bankservice=bankservice;
			}


			@GetMapping("/hello")
			public String hello() {

					return "Hello";
			}

			@GetMapping("/account")
			public AccountResponse showData() {

				return new AccountResponse(123,"Nalla Sivam",10000);

			}

			@PostMapping("/account")
			public String postData() {

				return "post data";
			}

			@PutMapping("/account")
			public String putData() {


				return "put data";
			}
			@DeleteMapping("/account")
			public String deleteData() {

				return "delete data";
			}

			@GetMapping("/account/{accountnumber}")
			public long getPathVariable(@PathVariable long accountnumber) {

				return accountnumber;
			}


			@GetMapping("/account/showresponse/{accountnumber}")
			public AccountResponse getAccountResponse(@PathVariable long accountnumber) {

				return new AccountResponse(accountnumber,"Arunachalam",10000);
			}


			@GetMapping("/account/requestparam")
			public String getRequestParam(@RequestParam long variable) {

				return "it is "+variable;
			}

	/*		@PostMapping("/account/data")
			public String accountRequest(@RequestBody AccountRequest accReq) {

				System.out.println(accReq.getAccountNumber());
			    System.out.println(accReq.getName());
			    System.out.println(accReq.getBalance());

				return "created";
			}


			@PostMapping("/account/responseentity/data")
			public ResponseEntity<String> accountRequest1(@RequestBody AccountRequest accReq) {

				System.out.println(accReq.getAccountNumber());
			    System.out.println(accReq.getName());
			    System.out.println(accReq.getBalance());

			    if(accReq.getBalance()<=0) {
			    	return ResponseEntity.badRequest().body("balance cant be zero or negative");
			    }

				return ResponseEntity.status(HttpStatus.CREATED).body("Account created");
			}


			@PostMapping("/account/responseentity1/data")
			public ResponseEntity<String> accountRequest2(@RequestBody AccountRequest accReq) {



			    if(accService.saveData(accReq)==false) {
			    	System.out.println("failed");
			    	return ResponseEntity.badRequest().body("balance cant be zero or negative");
			    }
					System.out.println("Sucess");
				return ResponseEntity.status(HttpStatus.CREATED).body("Account created");
			}
			*/


			@PostMapping("/account/datas")
			public ResponseEntity<AccountResponse> accountRequestData(@RequestBody AccountRequest accReq) {

				 AccountResponse response =
				            accService.createAccount(accReq);
					return ResponseEntity.status(HttpStatus.CREATED).body(response);
			}


			@PostMapping("/account/post/bankaccount")
			public ResponseEntity<String> saveDatainDb(@RequestBody BankAccount bankaccount){
				
					accService.saveData(bankaccount);
				
				return ResponseEntity.status(HttpStatus.CREATED).body("data stored in Database");
			}
			
			@GetMapping("/account/read/{id}")
			public ResponseEntity<BankAccount>readData(@PathVariable int id){
				
						BankAccount bank=bankservice.getDData(id);
						System.out.println(bank);
				return ResponseEntity.ok(bank);
			}
			
			
			@GetMapping("/account/readall")
			public ResponseEntity<ArrayList<BankAccount>>readall(){
				
						ArrayList<BankAccount> bankAccounts=bankservice.getAllData();
						System.out.println(bankAccounts);
				return ResponseEntity.ok(bankAccounts);
			}
			@DeleteMapping("/account/delete/{id}")
			public ResponseEntity<String>deleteAccount(@PathVariable int id){
				
							bankservice.deleteDatas(id);
					return ResponseEntity.ok("Deleted");
			}
			
			@GetMapping("/account/text/{name}")
			public ResponseEntity<BankAccount>getName(@PathVariable String name){
				
				return ResponseEntity.ok(bankservice.findNames(name));
							
			}
			
			@GetMapping("/account/texts/{name}")
			public ResponseEntity<List<BankAccount>>getNames(@PathVariable String name){
				
				return ResponseEntity.ok(bankservice.findAllSameNames(name));
							
			}
			
			@GetMapping("/account/nameandbalance/{name}/{balance}")
			public ResponseEntity<List<BankAccount>>getNamesAndBalance(@PathVariable String name,@PathVariable double balance){
				
				return ResponseEntity.ok(bankservice.findNameAndBalance(name,balance));
							
			}
			
			
			@GetMapping("/account/getRichAccounts/{balance}")
			public ResponseEntity<List<BankAccount>> controllerFindRichAccounts(@PathVariable double balance){
				
				
				
				return ResponseEntity.ok(bankservice.findManyRichAccounts(balance));
			}
			
			@GetMapping("/accounts/betwweenminandmax/{min}/{max}")
			public ResponseEntity<List<BankAccount>> controllerFindAccountsByMinMax(@PathVariable double min,@PathVariable double max){
				
					return ResponseEntity.ok(bankservice.findBalnceWithSomeConditions(min,max));
			}

			
			
			@GetMapping("/accounts/namebalancedesc/{name}/{min}/{max}")
			public ResponseEntity<List<BankAccount>> controllerFindByBalanceNameDDesc(@PathVariable String name ,@PathVariable double min,@PathVariable double max){
				
							System.out.println(name+ " " +min+ " " +max);
					return ResponseEntity.ok(bankservice.findByBalanceNameDesc(name,min,max));
			}
			
			@GetMapping("/accounts/customer/name/{name}")
			public ResponseEntity<List<BankAccount>> findSpecificCustomerAccounts(@PathVariable String name){
				
				
						return ResponseEntity.ok(bankservice.findCustomerAccounts(name));
			}
			
			@GetMapping("/accounts/get/customer/lessBalance/{id}/{balance}")
			public ResponseEntity<List<BankAccount>> findAccountsAndLesserBalance(@PathVariable int id,@PathVariable double balance){
				
					return ResponseEntity.ok(bankservice.findParticularCustomerBalanceLessThan(id, balance));
			}
			
			@PutMapping("/accounts/get/transactions/{from}/{to}/{amount}")
			public ResponseEntity<String> findAccountsAndDoTransactions(@PathVariable int from,@PathVariable int to,@PathVariable double amount){
				
					return ResponseEntity.ok(bankservice.findBankAccountAndTransaction(from, to, amount));
			}
			@GetMapping("/accounts/customer/count")
			public ResponseEntity<List<Object[]>> findCustomerAccountsWithCount(){
				
						return ResponseEntity.ok(bankservice.findCustomerAccounts());
			}
			
			@GetMapping("/accounts/customer/allcount")
			public ResponseEntity<List<Object[]>> findCustomerAccountsWithCountAll(){
				
						return ResponseEntity.ok(bankservice.findAllCustomerAccounts());
			}
			
			@GetMapping("/accounts/customer/allcountdto")
			public ResponseEntity<List<CustomerAccountCountDto>> findCustomerAccountsWithCountAllDto(){
				
						return ResponseEntity.ok(bankservice.findAllCustomerAccountsDto());
			}
			
			@GetMapping("/accounts/bankaccount/bankaccountdto/{id}")
			public ResponseEntity<BankAccountDto> findAccounts(@PathVariable int id){
				
						return ResponseEntity.ok(bankservice.findAccountById(id));
			}
			
			@PostMapping("/accounts/getMapper")
			public ResponseEntity<AccountResponse>createByMapper(@RequestBody AccountRequest accountrequest){
				
					return ResponseEntity.status(HttpStatus.CREATED).body(bankservice.giveAccounts(accountrequest));
			}
}
