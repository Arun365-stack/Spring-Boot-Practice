package com.Nallasivam.Spring_Practice;

public class CustomerAccountCountDto {

	
		private String name;
		private long accountCount;
		
		public CustomerAccountCountDto(String name,long accountCount) {
			
					this.name=name;
					this.accountCount=accountCount;
			}

		public String getName() {
			return name;
		}

		public long getAccountCount() {
			return accountCount;
		}
		
		
		}
