package com.bajaj.springbootdemo.repositories;

import com.bajaj.springbootdemo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // function name and parameter name should match the property in model
    // find by email id
    Optional<Customer> findByEmailId(String emailId);

    // function name and parameter name should match the property in model
    // find by email and mobile number
    Optional<Customer> findByEmailIdAndMobileNumber(String emailId, String mobileNumber);

    // find by email or gender
    List<Customer> findByEmailIdOrGender(String emailId, String gender);

    @Query("Select c from Customer c where c.name = ?1 and c.gender = ?2")
    List<Customer> findCustomers(String name, String gender);
}
