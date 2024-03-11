package com.bajaj.springbootdemo.controllers;

import com.bajaj.springbootdemo.beans.ResponseHandler;
import com.bajaj.springbootdemo.entities.Address;
import com.bajaj.springbootdemo.entities.Customer;
import com.bajaj.springbootdemo.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAddresses(@PathVariable Long id) {
        List<Address> addresses = addressService.getAddresses(id);
        return ResponseHandler.generateResponse("Addresses for customer", HttpStatus.OK, addresses);
    }

    @PostMapping("/createAddress")
    public ResponseEntity<Object> createAddress(@RequestBody Address address) {
        Address createdAddress = addressService.createAddress(address);
        return ResponseHandler.generateResponse("Address Created", HttpStatus.CREATED, createdAddress);
    }
}
