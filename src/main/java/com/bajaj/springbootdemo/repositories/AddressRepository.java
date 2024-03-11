package com.bajaj.springbootdemo.repositories;

import com.bajaj.springbootdemo.entities.Address;
import com.bajaj.springbootdemo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByCustomer(Customer customer);
}
