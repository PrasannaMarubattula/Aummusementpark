


package com.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Customer;
import com.service.CustomerService;

@RestController
@RequestMapping(path="/api")
public class CustomerController {
	
	@Autowired
	CustomerService customerservice ;
	
   @PostMapping("/insertCustomer")
	public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer )
	{
	Customer c1=customerservice.insertCustomer(customer);
	ResponseEntity re=new ResponseEntity<Customer>(c1,HttpStatus.OK);
	return re;
	}
	
   @PutMapping(path="/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws Throwable
	{
		Customer e1=customerservice.updateCustomer(customer);
		
		ResponseEntity re=new ResponseEntity<Customer>(e1,HttpStatus.OK);
		return re;
	}
   @DeleteMapping(path="/deleteCustomer")
	public ResponseEntity<String> deleteCustomer(@RequestBody Customer customer) 
	{
		customerservice.deleteCustomer(customer);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
   @GetMapping("/viewCustomers")
	public ResponseEntity<List<Customer>> viewCustomers() throws Throwable
	{
		List<Customer> lc1=customerservice.viewCustomers();
		ResponseEntity re=new ResponseEntity<List<Customer>>(lc1,HttpStatus.OK);
		return re;
	}
	
   @GetMapping(path="/viewCustomer/{customerid}")
	public ResponseEntity<Customer> viewCustomerById(@PathVariable int customerid) throws Throwable
	{
		Customer c1=customerservice.viewCustomerById(customerid);
		
		ResponseEntity re=new ResponseEntity<Customer>(c1,HttpStatus.OK);
		return re;
	}

/*	@GetMapping("/viewCustomers/{activityName}")
	public ResponseEntity<List<Customer>> viewCustomeListByActivity(@PathVariable String activityName) throws Throwable 
	{
		List<Customer> lc=customerservice.viewCustomerListByActivity(activityName);
		ResponseEntity re=new ResponseEntity<List<Customer>>(lc,HttpStatus.OK);
		return re;
	}	
	@GetMapping("/viewCustomers/{date}")
	public ResponseEntity<List<Customer>> viewCustomeListByDate(@PathVariable LocalDate date) throws Throwable 
	{
		List<Customer> lc=customerservice.viewCustomerListByDate(date);
		ResponseEntity re=new ResponseEntity<List<Customer>>(lc,HttpStatus.OK);
		return re;
	}	*/

	@DeleteMapping(path="/deleteCustomer/{eid}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable int eid) throws Throwable
	{
		customerservice.deleteCustomerById(eid);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
}
