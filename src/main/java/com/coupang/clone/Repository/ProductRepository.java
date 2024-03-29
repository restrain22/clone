package com.coupang.clone.Repository;

import com.coupang.clone.domain.Product;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(Long id);
    void deleteById(Long Id);
    Optional<Product> findByRegisteredDateAndName(Date date, String Name);
    List<Product> findByNameContaining(String name);
}
