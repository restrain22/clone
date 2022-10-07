package com.coupang.clone.Repository;

import com.coupang.clone.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCartRepository extends JpaRepository<Cart,Long>, CartRepository {
}
