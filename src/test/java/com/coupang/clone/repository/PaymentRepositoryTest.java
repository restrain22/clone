package com.coupang.clone.repository;

import com.coupang.clone.Repository.MemberRepository;
import com.coupang.clone.Repository.PaymentDetailRepository;
import com.coupang.clone.Repository.PaymentRepository;
import com.coupang.clone.domain.Member;
import com.coupang.clone.domain.Payment;
import com.coupang.clone.domain.PaymentDetail;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class PaymentRepositoryTest {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PaymentDetailRepository paymentDetailRepository;

    @Test
    void save() {
        Member member = memberRepository.findById(2L).get();

        Payment payment = Payment.builder()
                .member(member)
                .orderTime(new Date())
                .phoneNumber(member.getPhoneNumber())
                .shipStatus("입고중")
                .totalPrice("1,000")
                .address("주소")
                .build();

        paymentRepository.save(payment);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void deleteById() {
    }
}