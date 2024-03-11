package com.bajaj.springbootdemo.services;

import com.bajaj.springbootdemo.entities.Customer;
import com.bajaj.springbootdemo.entities.Product;
import com.bajaj.springbootdemo.exceptions.EntityAlreadyExistException;
import com.bajaj.springbootdemo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        if (productRepository.findByProductCode(product.getProductCode()).isEmpty()) {
            return productRepository.save(product);
        }
        throw new EntityAlreadyExistException("Product with product code already exist");
    }
}
