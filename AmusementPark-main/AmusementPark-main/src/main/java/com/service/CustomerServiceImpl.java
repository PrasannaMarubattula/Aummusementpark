package com.service;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.CustomerNotFoundException;
import com.entity.Customer;
import com.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	

	@Override
	public Customer insertCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) throws Throwable {
		int id=customer.getCustomerId();
		Supplier s1= ()->new CustomerNotFoundException("Customer Id Does not exist in the database");
		Customer c1=customerRepo.findById(id).orElseThrow(s1); 
				
				c1.setEmail(customer.getEmail());
				c1.setFirstName(customer.getFirstName());
				c1.setLastName(customer.getLastName());
				c1.setMobileNumber(customer.getMobileNumber());
				c1.setPassword(customer.getPassword());
				c1.setUsername(customer.getUsername());
				customerRepo.save(c1);
				return c1;
	}

	@Override
	public String deleteCustomer(Customer customer){
	
		customerRepo.delete(customer);
		
		return "Deleted";
	}

	@Override
	public String deleteCustomerById(int customerid) throws Throwable {
		
		Supplier s2= ()->new CustomerNotFoundException("Coder id Does not exist in the database");
	Customer c1=customerRepo.findById(customerid).orElseThrow(s2);
	customerRepo.deleteById(customerid);
	
	return "Deleted";
}

	@Override
	public List<Customer> viewCustomers(){
	List<Customer> ls=customerRepo.findAll();
		return ls;
	}

	@Override
	public Customer viewCustomerById(int customerId) throws Throwable{
		Supplier s1= ()->new CustomerNotFoundException("Customer Id Does not exist in the database");
		
		Customer c1=customerRepo.findById(customerId).orElseThrow(s1);
		return c1;
	}

	@Override
	public List<Customer> viewCustomerListByActivity(String activityName) throws Throwable{
		Supplier s1= ()->new CustomerNotFoundException("Customer Does not exist in the database");
		List<Customer> ls=customerRepo.findAllByActivity(activityName).orElseThrow(s1);		
		return ls;
	}

	@Override
	public List<Customer> viewCustomerListByDate(LocalDate date) throws Throwable {
	    Supplier s1= ()->new CustomerNotFoundException("Customer Does not exist in the database");
		List<Customer> lc=customerRepo.findAllByDate(date).orElseThrow(s1);
		return lc;
	}

}
