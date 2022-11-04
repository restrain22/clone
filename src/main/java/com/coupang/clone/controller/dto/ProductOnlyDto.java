package com.coupang.clone.controller.dto;

import com.coupang.clone.domain.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductOnlyDto {
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
    public ProductOnlyDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.stock = product.getPrice();
        this.registeredDate = product.getRegisteredDate();
        this.updatedDate = product.getUpdatedDate();
        this.info = product.getInfo();
        this.rateAvg = product.getRateAvg();
        this.imageName = product.getImageName();
        this.imageHref = product.getImageHref();
    }

    public ProductOnlyDto toDto(Product product) {
        return new ProductOnlyDto(product);
    }
}
