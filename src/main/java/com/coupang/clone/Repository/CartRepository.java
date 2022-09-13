package com.coupang.clone.Repository;

import com.coupang.clone.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CartRepository{
    Cart save(Cart cart);
    Optional<Cart> findById(Long id);
}
