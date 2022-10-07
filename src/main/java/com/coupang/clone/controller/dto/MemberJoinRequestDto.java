package com.coupang.clone.controller.dto;

import com.coupang.clone.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberJoinRequestDto {
    private String loginId;
    private String name;
    private String password;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String birth;
    private String type;

    @Builder
    public MemberJoinRequestDto(String loginId, String password,String name, String gender, String phoneNumber, String email, String address, String birth, String type) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.birth = birth;
        this.type = type;
    }

    public Member toEntity(){
        return Member.builder()
                .loginId(loginId)
                .name(name)
                .password(loginId)
                .gender(gender)
                .phoneNumber(phoneNumber)
                .email(email)
                .address(address)
                .birth(birth)
                .type(type)
                .build();
    }
}
