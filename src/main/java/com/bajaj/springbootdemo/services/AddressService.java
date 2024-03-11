package com.bajaj.springbootdemo.services;

import com.bajaj.springbootdemo.entities.Address;
import com.bajaj.springbootdemo.entities.Customer;
import com.bajaj.springbootdemo.exceptions.EntityAlreadyExistException;
import com.bajaj.springbootdemo.exceptions.EntityNotFoundException;
import com.bajaj.springbootdemo.repositories.AddressRepository;
import com.bajaj.springbootdemo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CustomerRepository customerRepository;

    public List<Address> getAddresses(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Customer with given id not found."));
        return addressRepository.findByCustomer(customer);
    }

    public Address createAddress(Address address) {
        Customer customer = customerRepository.findById(address.getCustomer().getId()).orElseThrow(()-> new EntityNotFoundException("Customer with given id not found."));
        return addressRepository.save(address);
    }
}
