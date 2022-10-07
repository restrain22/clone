package com.coupang.clone.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    private String productName; //상품명
    private int price; //가격
    private int stock; //재고
    private Date registerDate; //등록일
    private String productInfo; //상품정보

    //memberid(FK) 등록자
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    //categoryid(FK) 카테고리
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    //cartProduct에서 참조
    @OneToMany(mappedBy = "product")
    private List<CartProduct> list = new ArrayList<>();

    //paymentDetail에서 참조
    @OneToMany(mappedBy = "product")
    private List<PaymentDetail> paymentDetails = new ArrayList<>();

    @Builder
    public Product(Long id, String productName, int price, int stock, Date registerDate, String productInfo) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.registerDate = registerDate;
        this.productInfo = productInfo;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", registerDate=" + registerDate +
                ", productInfo='" + productInfo + '\'' +
                ", member=" + member +
                ", category=" + category +
                ", list=" + list +
                ", paymentDetails=" + paymentDetails +
                '}';
    }
}
