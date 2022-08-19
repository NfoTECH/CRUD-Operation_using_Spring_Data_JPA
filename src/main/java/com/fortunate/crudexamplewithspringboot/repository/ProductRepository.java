package com.fortunate.crudexamplewithspringboot.repository;

import com.fortunate.crudexamplewithspringboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
