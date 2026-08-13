package com.Nallasivam.Spring_Practice;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope("prototype")
public class TestBean {

	@PostConstruct
	public void init() {
			
		System.out.println("Test bean created");
	}
	
	@PreDestroy
	public void destroy() {	
		
		
		System.out.println("Test bean destroyed");
	}
}
