package com.coupang.clone.Repository;

import com.coupang.clone.domain.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCartProductRepository extends JpaRepository<CartProduct,Long>,CartProductRepository {
}
