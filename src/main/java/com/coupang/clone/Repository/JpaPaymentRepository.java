package com.coupang.clone.Repository;

import com.coupang.clone.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPaymentRepository extends JpaRepository<Payment, Long>, PaymentRepository {

}
