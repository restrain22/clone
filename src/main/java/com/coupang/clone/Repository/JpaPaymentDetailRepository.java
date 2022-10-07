package com.coupang.clone.Repository;

import com.coupang.clone.domain.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPaymentDetailRepository extends JpaRepository<PaymentDetail,Long>,PaymentDetailRepository {
}
