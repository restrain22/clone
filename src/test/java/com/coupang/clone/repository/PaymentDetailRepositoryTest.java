package com.coupang.clone.repository;

import com.coupang.clone.Repository.PaymentDetailRepository;
import com.coupang.clone.Repository.PaymentRepository;
import com.coupang.clone.Repository.ProductRepository;
import com.coupang.clone.domain.Payment;
import com.coupang.clone.domain.PaymentDetail;
import com.coupang.clone.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
class PaymentDetailRepositoryTest {

    @Autowired
    PaymentDetailRepository paymentDetailRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    void save() {
        PaymentDetail paymentDetail = PaymentDetail.builder()
                .count(5)
                .price(150)
                .build();

        Product product = productRepository.findById(2L).get();
        Payment payment = paymentRepository.findById(1L).get();

        paymentDetail.setProduct(product);
        paymentDetail.setPayment(payment);

        paymentDetailRepository.save(paymentDetail);
    }

    @Test
    void findById() {
        PaymentDetail paymentDetail = paymentDetailRepository.findById(1L).get();
        assertThat(paymentDetail.getCount()).isEqualTo(1);
    }

    @Test
    void findByPaymentIdAndProductId() {
        PaymentDetail paymentDetail = paymentDetailRepository.findByPaymentIdAndProductId(1L, 2L).get();
        assertThat(paymentDetail.getPayment().getMember().getId()).isEqualTo(1L);
    }
}