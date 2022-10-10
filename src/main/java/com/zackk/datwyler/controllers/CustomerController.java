package com.zackk.datwyler.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.zackk.datwyler.models.Customer;
import com.zackk.datwyler.repository.CustomerRepository;

import java.util.List;
import java.net.URISyntaxException;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomer(Long id) {
        return customerRepository.findOne(id);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity createCustomer(@RequestBody Customer customer) throws URISyntaxException {
        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.created(new URI("/api/customers" + savedCustomer.getId())).body(savedCustomer);
    }

    // Due to my original mapping while testing, I have this endpoint in use
    // Hopefully The same query can cover it due to the one to many mapping
    @RequestMapping(value = "/customer-details/{id}", method = RequestMethod.GET)
    public Customer getCustomerWithLoan(Long id) {
        return customerRepository.findOne(id);
    }

}
