package com.coupang.clone.domain;

import lombok.Getter;

@Getter
public enum Type{
    ADMIN,
    SELLER,
    PURCHASER;

//    ADMIN("admin"),
//    SELLER("seller"),
//    PURCHASER("user");
//
//    private String type;
//
//    Type(String type) {
//        this.type = type;
//    }
}