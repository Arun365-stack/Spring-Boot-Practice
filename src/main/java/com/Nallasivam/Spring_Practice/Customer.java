package com.Nallasivam.Spring_Practice;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String aadharNumber;
	
	@OneToMany(mappedBy="customer")
	private List<BankAccount> accounts;
	
	public Customer(int id, String name, String email, String aadharNumber, List<BankAccount> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.aadharNumber = aadharNumber;
		this.accounts=accounts;
	}

	public Customer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public List<BankAccount>getAccounts(){
		return accounts;
	}	
	public void setAccounts(List<BankAccount>accounts) {
		
			this.accounts=accounts;
	}
}
