package com.bajaj.springbootdemo.controllers;

import com.bajaj.springbootdemo.beans.ResponseHandler;
import com.bajaj.springbootdemo.entities.Customer;
import com.bajaj.springbootdemo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllCustomers() {
        return ResponseHandler.generateResponse("Customers Found", HttpStatus.OK, customerService.getAllCustomers());
    }

    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);
        return ResponseHandler.generateResponse("Customer Found", HttpStatus.OK, customer);
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseHandler.generateResponse("Customer Created", HttpStatus.CREATED, createdCustomer);
    }

//    @DeleteMapping("/delete/{id}")
//    public String deleteCustomer(@PathVariable Integer id) {
//        customerRepository.deleteById(id);
//        return "Customer deleted successfully!";
//    }
}
