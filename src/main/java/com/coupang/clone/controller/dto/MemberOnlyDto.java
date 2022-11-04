package com.coupang.clone.controller.dto;

import com.coupang.clone.domain.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MemberOnlyDto {
    private Long id;
    private String loginId;
    private String name;
    private String password;
    private Gender gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String birth;
    private Grade grade;
    private Type type;

    @Builder
    public MemberOnlyDto(Member member) {
        this.id = member.getId();
        this.loginId = member.getLoginId();
        this.name = member.getName();
        this.password = member.getPassword();
        this.gender =Gender.valueOf(member.getGender());
        this.phoneNumber = member.getPhoneNumber();
        this.email = member.getEmail();
        this.address = member.getAddress();
        this.birth = member.getBirth();
        this.grade = member.getGrade();
        this.type =member.getType();
    }

    public MemberOnlyDto toDto(Member member) {
        return new MemberOnlyDto(member);
    }

}
