package com.Nallasivam.Spring_Practice;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class DepositRequestDto {
	
    @Positive(message = "Deposit amount must be positive")		
    private double amount;
		
		public DepositRequestDto(double amount) {
			this.amount=amount;
		}

		public double getAmount() {
			return amount;
		}

		
}
