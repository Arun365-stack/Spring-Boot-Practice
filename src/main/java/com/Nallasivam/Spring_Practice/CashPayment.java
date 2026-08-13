package com.Nallasivam.Spring_Practice;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CashPayment implements Payment{

	@Override
	public void pay(double amount) {
		System.out.println("Cash Payment " +amount);
	}

}
