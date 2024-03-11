package com.bajaj.springbootdemo.controllers;

import com.bajaj.springbootdemo.beans.ResponseHandler;
import com.bajaj.springbootdemo.entities.Customer;
import com.bajaj.springbootdemo.entities.Product;
import com.bajaj.springbootdemo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllProducts() {
        return ResponseHandler.generateResponse("Products Found", HttpStatus.OK, productService.getAllProducts());
    }

    @PostMapping("/createProduct")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseHandler.generateResponse("Product Created", HttpStatus.CREATED, createdProduct);
    }
}
