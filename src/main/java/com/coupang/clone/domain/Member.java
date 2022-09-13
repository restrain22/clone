package com.coupang.clone.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberID;
    private String name;
    private String password;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String birth;
    private String type;

    public Member(Long memberID, String name, String gender, String phoneNumber, String email, String address, String birth, String type) {
        this.memberID = memberID;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.birth = birth;
        this.type = type;
    }
}
