package com.Nallasivam.Spring_Practice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface AccountRepository extends JpaRepository<BankAccount,Integer >{

			BankAccount findByName(String text);
			
			List<BankAccount> findByNameContaining(String text);
			
			List<BankAccount> findByNameAndBalanceGreaterThan(String name,double balance);
			
			// query and jpql
			
			@Query("""
				    SELECT a
				    FROM BankAccount a
				    WHERE a.balance > :balance
				    ORDER BY a.balance DESC
				""")
			List<BankAccount> findRichAccounts(@Param("balance")double balance);
			
			@Query("""
					SELECT a 
					FROM BankAccount a 
					WHERE a.balance BETWEEN :min AND :max
				""")
			List<BankAccount> findByBalance(@Param("min") double min,@Param("max") double max);
			
			@Query("""
					SELECT a 
					FROM BankAccount a 
					WHERE a.name LIKE CONCAT('%', :name, '%') AND a.balance BETWEEN :min AND :max ORDER BY a.balance DESC
				""")
			List<BankAccount> findByBalanceAndNameContaining(@Param("name") String name,@Param("min") double min,@Param("max") double max);
			
			@Query(""" 
					SELECT a FROM BankAccount a JOIN a.customer c WHERE c.name= :name
					""")
			List<BankAccount>findAccountsByCustomerName(@Param("name")String name);
			
			@Query("""
					 SELECT a FROM BankAccount a JOIN a.customer c WHERE c.id=:id AND a.balance < :balance
					""")
			List<BankAccount> findParticularCustomerWhoisHavingBalanceLessThan(@Param ("id")int id,@Param("balance")double balance);
}
