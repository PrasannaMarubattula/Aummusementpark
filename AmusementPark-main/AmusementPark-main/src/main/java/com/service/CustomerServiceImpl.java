package com.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Customer updateCustomer(Customer customer) {
		int id=customer.getCustomerId();
		Customer c1=customerRepo.findById(id).orElseThrow(); 
				
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
	public String deleteCustomer(Customer customer) {
		customerRepo.delete(customer);
		
		return "Deleted";
	}

	@Override
	public List<Customer> viewCustomers() {
		List<Customer> ls=customerRepo.findAll();
		return ls;
	}

	@Override
	public Customer viewCustomerById(int customerId) {
		Customer c1=customerRepo.findById(customerId).orElseThrow();
		return c1;
	}

	@Override
	public List<Customer> viewCustomerListByActivity(String activityName) {
		List<Customer> ls=customerRepo.findAllByActivity(activityName);		
		return ls;
	}

	@Override
	public List<Customer> viewCustomerListByDate(LocalDate date) {
		List<Customer> lc=customerRepo.findAllByDate(date);
		return lc;
	}

}
