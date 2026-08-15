package com.Nallasivam.Spring_Practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankConfiguration {

	@Bean
	public BankAccount bankaccount() {

		return new BankAccount();

	}


}
