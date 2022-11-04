package com.coupang.clone.domain;

import com.coupang.clone.controller.dto.ProductResponseDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@ToString(exclude = {"paymentDetails","list","comment","favorites","qna"})
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    private String name; //상품명
    private int price; //가격
    private int stock; //재고
    private Date registeredDate; //등록일
    private Date updatedDate; //갱신일
    private String info; //상품정보
    private double rateAvg; //상품 평점
    private String imageName; //이미지 파일 명
    private String imageHref; //이미지 파일 경로

    @ManyToOne    //memberid(FK) 등록자
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne     //categoryid(FK) 카테고리
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")     //QuestionNAnswer에서 참조
    private List<QuestionNAnswer> qna;

    @OneToMany(mappedBy = "product")     //Comment에서 참조
    private List<Comment> comment = new ArrayList<>();

    @OneToMany(mappedBy = "product")    //cartProduct에서 참조
    private List<CartProduct> list = new ArrayList<>();

    @OneToMany(mappedBy = "product")    //paymentDetail에서 참조
    private List<PaymentDetail> paymentDetails = new ArrayList<>();

    @OneToMany(mappedBy = "product")    //Favorite에서 참조
    private List<Favorite> favorites = new ArrayList<>();

    @Builder
    public Product(String name, int price, int stock, String info, Member member, Category category) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.registeredDate = new Date();
        this.updatedDate = registeredDate;
        this.info = info;
        this.rateAvg = 0.0;
    }

    public void joinMemberAndCategory(Member member, Category category) {
        this.member = member;
        this.category = category;
        this.registeredDate = new Date();
    }

    public void updateFile(String imageName, String imageHref) {
        insertFile(imageName, imageHref);
        this.updatedDate = new Date();
    }

    public void insertFile(String imageName, String imageHref) {
        this.imageName = imageName;
        this.imageHref = imageHref;
    }
    public void updateRateAVg(double rateAvg) {
        this.rateAvg = rateAvg;
    }
}