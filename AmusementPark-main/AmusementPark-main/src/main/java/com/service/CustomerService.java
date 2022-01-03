package com.service;

import java.time.LocalDate;
import java.util.List;

import com.entity.Customer;

public interface CustomerService {
	public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public String deleteCustomer(Customer customer);
	public List<Customer>viewCustomers();
	public Customer viewCustomerById(int customerId);
	public List<Customer> viewCustomerListByActivity(String activityName);
	public List<Customer> viewCustomerListByDate(LocalDate date);

}
