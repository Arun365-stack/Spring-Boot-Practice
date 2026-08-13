package com.Nallasivam.Spring_Practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringPracticeApplication {

	public static void main(String[] args) {
		  ApplicationContext context =
				  SpringApplication.run(SpringPracticeApplication.class, args);
		  
		  
		/*  		Payment payment=context.getBean(UpiPayment.class);
		  		
		  				payment.save(100); */
		  
		  			PaymentService ps=context.getBean(PaymentService.class);
		  			
		  							ps.makePayment(100);
		  									
		  			BankService bs=context.getBean(BankService.class);	
		  			
		  						bs.show();
		  						
		  			TestBean testbean=context.getBean(TestBean.class);
		  			
		  			TestBean testbean1=context.getBean(TestBean.class);
		  			
		  				System.out.println(testbean==testbean1);
		  			
	}

}
