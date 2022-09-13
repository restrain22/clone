package com.coupang.clone.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;
    private Long memberID;
    private ArrayList<Long> products;
    private String address;
    private String shipStatus;
    private String totalPrice;
    private String phoneNUmber;
    private Date orderTime;
}


