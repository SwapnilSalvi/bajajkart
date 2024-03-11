package com.bajaj.springbootdemo.services;

import com.bajaj.springbootdemo.entities.CartItem;
import com.bajaj.springbootdemo.entities.Customer;
import com.bajaj.springbootdemo.entities.Product;
import com.bajaj.springbootdemo.exceptions.EntityAlreadyExistException;
import com.bajaj.springbootdemo.exceptions.EntityNotFoundException;
import com.bajaj.springbootdemo.repositories.CartItemRepository;
import com.bajaj.springbootdemo.repositories.CustomerRepository;
import com.bajaj.springbootdemo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    public CartItem createCartItem(CartItem cartItem) {
        if (cartItem.getQuantity() > 0) {
            Product product = productRepository.findById(cartItem.getProduct().getId()).orElseThrow(()-> new EntityNotFoundException("Product with given id doesn't exist."));
            Customer customer = customerRepository.findById(cartItem.getCustomer().getId()).orElseThrow(()-> new EntityNotFoundException("Customer with given id doesn't exist."));
            if (cartItemRepository.findByCustomerAndProduct(customer, product).isPresent()) {
                throw new EntityAlreadyExistException("Product already present in cart.");
            }else{
                return cartItemRepository.save(cartItem);
            }
        }else {
            throw new RuntimeException("Quantity should be greater than 0.");
        }
    }

    public List<CartItem> getCustomerCart(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new EntityNotFoundException("Customer with given id doesn't exist."));
        List<CartItem> cartItems = cartItemRepository.findByCustomer(customer);
        return cartItems;
    }
}
