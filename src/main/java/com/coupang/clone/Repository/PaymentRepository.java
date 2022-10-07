package com.coupang.clone.Repository;

import com.coupang.clone.domain.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
    Payment save(Payment payment);
    Optional<Payment> findById(Long id);
    List<Payment> findAll();
    void deleteById(Long id);
}
