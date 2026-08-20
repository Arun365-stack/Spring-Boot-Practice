package com.Nallasivam.Spring_Practice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
	@Query("""
			SELECT c From Customer c LEFT JOIN c.accounts a
			""")
	List<Customer>findAllCustomerIncludingNoAccounts();
	
	@Query("""
			SELECT c From Customer c LEFT JOIN FETCH c.accounts a
			""")
	List<Customer>findAllCustomerIncludingNoAccountsWithoutLazy();

	@Query(value = """
		    SELECT *
		    FROM customer
		    WHERE name LIKE CONCAT('%', :name, '%')
		    """, nativeQuery = true)
	List<Customer>findAllCustomersWithSpecificNames(@Param("name") String name);
	
	@Query("""
		    SELECT NEW com.Nallasivam.Spring_Practice.CustomerAccountCountDto(
		        c.name,
		        COUNT(a)
		    )
		    FROM Customer c
		    LEFT JOIN c.accounts a
		    GROUP BY c.id, c.name
		    HAVING COUNT(a) > 1
		""")
		List<CustomerAccountCountDto> findCustomersWithMoreThanOneAccount();
	
}
