package com.coupang.clone.controller.dto;

import com.coupang.clone.domain.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class MemberResponseDto {
    private Long id;
    private String loginId;
    private String name;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String birth;
    private String type;
    private String grade;

    @Builder
    public MemberResponseDto(Long id, String loginId, String name,Gender gender, String phoneNumber, String email, String address, String birth, Type type, Grade grade) {
        this.id = id;
        this.loginId = loginId;
        this.name = name;
        this.gender = gender.getCapital();
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.birth = birth;
        this.type = type.name();
        this.grade = grade.name();
    }

    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.loginId = member.getLoginId();
        this.name = member.getName();
        this.gender = member.getGender();
        this.phoneNumber = member.getPhoneNumber();
        this.email = member.getEmail();
        this.address = member.getAddress();
        this.birth = member.getBirth();
        this.type = member.getType().name();
        this.grade = member.getGrade().name();
    }
    public static MemberResponseDto of(Member member) {
        return new MemberResponseDto(member);
    }
}
