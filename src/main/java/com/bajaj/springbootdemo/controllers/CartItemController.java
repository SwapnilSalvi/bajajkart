package com.bajaj.springbootdemo.controllers;

import com.bajaj.springbootdemo.beans.ResponseHandler;
import com.bajaj.springbootdemo.entities.CartItem;
import com.bajaj.springbootdemo.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/addToCart")
    public ResponseEntity<Object> createCartItems(@RequestBody CartItem cartItem) {
        CartItem createdCartItem = cartItemService.createCartItem(cartItem);
        return ResponseHandler.generateResponse("Item added to cart", HttpStatus.CREATED, null);
    }

    @GetMapping("/getCustomerCart/{customerId}")
    public  ResponseEntity<Object> getCustomerCart(@PathVariable Long customerId) {
        List<CartItem> customerCart = cartItemService.getCustomerCart(customerId);
        return ResponseHandler.generateResponse("Customer cart", HttpStatus.OK, customerCart);
    }
}
