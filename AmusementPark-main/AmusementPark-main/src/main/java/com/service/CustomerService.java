package com.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.advices.CustomerNotFoundException;
import com.entity.Customer;
@Service
public interface CustomerService {
	public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Customer customer) throws  Throwable;
	public String deleteCustomer(Customer customer) ;
	public List<Customer>viewCustomers() ;
	public Customer viewCustomerById(int customerId) throws Throwable;
	public List<Customer> viewCustomerListByActivity(String activityName) throws Throwable;
	public List<Customer> viewCustomerListByDate(LocalDate date) throws Throwable;
	public String deleteCustomerById(int cid) throws Throwable;

}
