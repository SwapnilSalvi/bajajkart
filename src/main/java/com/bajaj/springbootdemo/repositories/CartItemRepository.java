package com.bajaj.springbootdemo.repositories;

import com.bajaj.springbootdemo.entities.CartItem;
import com.bajaj.springbootdemo.entities.Customer;
import com.bajaj.springbootdemo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByCustomer(Customer customer);
    Optional<CartItem> findByCustomerAndProduct(Customer customer, Product product);
}
