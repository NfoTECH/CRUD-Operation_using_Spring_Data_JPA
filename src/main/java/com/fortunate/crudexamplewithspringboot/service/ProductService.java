package com.fortunate.crudexamplewithspringboot.service;

import com.fortunate.crudexamplewithspringboot.model.Product;
import com.fortunate.crudexamplewithspringboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> listAllProduct() {
        return repository.findAll();
    }

    public void saveProduct(Product product) {
        this.repository.save(product);
    }

    public Product get(Long id) {
        Optional<Product> optional = repository.findById(id);
        Product product;
        if (optional.isPresent()) product = optional.get();
        else throw new RuntimeException("Product not found for id :: " + id);
        return product;
    }

    public void deleteProductById(Long id) {
        this.repository.deleteById(id);
    }
}
