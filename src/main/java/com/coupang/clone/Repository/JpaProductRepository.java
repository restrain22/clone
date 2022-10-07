package com.coupang.clone.Repository;

import com.coupang.clone.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository  extends JpaRepository<Product,Long>,ProductRepository {
}
