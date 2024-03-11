package com.bajaj.springbootdemo.repositories;

import com.bajaj.springbootdemo.entities.Customer;
import com.bajaj.springbootdemo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // function name and parameter name should match the property in model
    // find by product code
    Optional<Product> findByProductCode(String productCode);
}
