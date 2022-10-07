package com.coupang.clone.Repository;

import com.coupang.clone.domain.PaymentDetail;

import java.util.Optional;

public interface PaymentDetailRepository {
    PaymentDetail save(PaymentDetail paymentDetail);
    Optional<PaymentDetail> findById(Long id);
    Optional<PaymentDetail> findByPaymentIdAndProductId(Long paymentId, Long productId);

}
