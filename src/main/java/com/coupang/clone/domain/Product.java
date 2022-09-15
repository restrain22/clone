package com.coupang.clone.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ProductID;
    private Long categoryID;
    private String ProductName;
    private int price;
    private String ProductOwnerID;
    private int stock; //재고
    private Date registerDate;
    private String productInfo;
}
