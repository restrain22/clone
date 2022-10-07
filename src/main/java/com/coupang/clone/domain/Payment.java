package com.coupang.clone.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;
    private String address;
    private String shipStatus; //나중에 enum으로 변경
    private String totalPrice;
    private String phoneNumber;
    private Date orderTime;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "payment")
    private List<PaymentDetail> paymentDetails = new ArrayList<>();

    @Builder
    public Payment(String address, String shipStatus, String totalPrice, String phoneNumber, Date orderTime, Member member) {
        this.address = address;
        this.shipStatus = shipStatus;
        this.totalPrice = totalPrice;
        this.phoneNumber = phoneNumber;
        this.orderTime = orderTime;
        this.member = member;
    }
}


