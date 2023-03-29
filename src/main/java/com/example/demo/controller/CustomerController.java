package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repo.CustomerRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

@RequestMapping("/api/v1/")
public class CustomerController {

	@Autowired
	private CustomerRepo customerRepo;

	@GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@PostMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer createCustomer(@RequestBody Customer cust) {
		System.out.println("inside post method of create customer");
		return customerRepo.save(cust);

	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {

		Customer customer = customerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("customer not exist with id:" + id));
		return ResponseEntity.ok(customer);

	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer custData) {

		Customer customer = customerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("customer not exist with id:" + id));
		customer.setFirstName(custData.getFirstName());
		customer.setLastName(custData.getLastName());
		customer.setEmailId(custData.getEmailId());

		Customer updatedCustData = customerRepo.save(customer);
		return ResponseEntity.ok(updatedCustData);

	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Map<String,Boolean>> DeleteCustomer(@PathVariable(required=false)  Long id,@RequestBody (required=false) List<Long> idList) {
		System.out.println("inside Deletemapping===>"+id);

		Customer customer = customerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("customer not exist with id:" + id));

		customerRepo.delete(customer);
		Map<String,Boolean> response = new HashMap<String,Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}
	@DeleteMapping("/customers")
	public ResponseEntity<Map<String,Boolean>> DeleteAllCustomer(@RequestBody (required=false) Set<Long> idList) {
		
		customerRepo.deleteAllById(idList);
		Map<String,Boolean> response = new HashMap<String,Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}

}
