package com.Nallasivam.Spring_Practice;

import org.springframework.stereotype.Component;

@Component
public class CardPayment implements Payment{

	@Override
	public void pay(double amount) {

		System.out.println("card payment " +amount);

	}

}
