package com.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advices.CustomerNotFoundException;
import com.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> 
{
	public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Customer customer)  throws Throwable ;
	public Customer deleteCustomer(Customer customer)  ;
	public List<Customer>viewCustomers() ;
	public Customer viewCustomer(int customerId) throws Throwable ;
	public Customer validateCustomer(String username, String password) throws Throwable ;
	public List<Customer> findAllByActivity(String activityName) throws Throwable ;
	public List<Customer> findAllByDate(LocalDate date) throws Throwable ;
	public String deleteCustomerById(int cid) throws Throwable;
	


}
