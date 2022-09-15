package com.coupang.clone.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seqID;
    private String memberID;
    private String name;
    private String password;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String birth;
    private String type;

    @Builder
    public Member(String memberID, String password,String name, String gender, String phoneNumber, String email, String address, String birth, String type) {
        this.memberID = memberID;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.birth = birth;
        this.type = type;
    }
}
