package com.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> 
{
	public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Customer customer) ;
	public Customer deleteCustomer(Customer customer) ;
	public List<Customer>viewCustomers() ;
	public Customer viewCustomer(int customerId) ;
	public Customer validateCustomer(String username, String password);
	public List<Customer> findAllByActivity(String activityName);
	public List<Customer> findAllByDate(LocalDate date);
	


}
