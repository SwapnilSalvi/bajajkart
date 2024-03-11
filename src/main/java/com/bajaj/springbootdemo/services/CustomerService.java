package com.bajaj.springbootdemo.services;

import com.bajaj.springbootdemo.entities.Customer;
import com.bajaj.springbootdemo.exceptions.EntityAlreadyExistException;
import com.bajaj.springbootdemo.exceptions.EntityNotFoundException;
import com.bajaj.springbootdemo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Customer not found with given id."));
    }

    public Customer createCustomer(Customer customer) {
        if (customerRepository.findByEmailId(customer.getEmailId()).isEmpty()) {
            return customerRepository.save(customer);
        }
        throw new EntityAlreadyExistException("Customer with email id already exist");
    }
}
