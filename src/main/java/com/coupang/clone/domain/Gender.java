package com.coupang.clone.domain;

import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum Gender {
    Woman("Female", "F"),
    Man("Male", "M"),
    ;

    private final String sex;
    private final String capital;

//    private static final Map<String, String> gender_map =
//            Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(Gender::getCapital, Gender::name)));
//    public static Gender of(final String capital){
//        return Gender.valueOf(gender_map.get(capital));
//    }


    Gender(String sex, String capital) {
        this.sex = sex;
        this.capital = capital;
    }
}
