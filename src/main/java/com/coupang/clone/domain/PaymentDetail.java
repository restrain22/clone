package com.coupang.clone.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class PaymentDetail {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int count;
    private int price;

    @Builder
    public PaymentDetail(int count, int price) {
        this.count = count;
        this.price = price;
    }
}
