package com.coupang.clone.controller.dto;

import com.coupang.clone.domain.Gender;
import com.coupang.clone.domain.Grade;
import com.coupang.clone.domain.Member;
import com.coupang.clone.domain.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class MemberRequestDto {
    private Long id;

    @Length(min = 1,max = 20, message = "ID는 1~20자리만 가능합니다")
    @NotBlank(message = "로그인 ID는 필수 값입니다.")
    private String loginId;

    @NotBlank(message = "이름은 필수 값입니다.")
    private String name;

    @JsonIgnore
    //@NotBlank(message = "비밀번호는 필수 값입니다.")
    private String password;

    @NotNull(message = "성별은 필수 값입니다.")
    private Gender gender;

    private String phoneNumber;

    @NotBlank(message = "이메일은 필수 값입니다.")
    @Email
    private String email;

    private String address;

    private String birth;

//    @NotBlank(message = "등급은 필수 값입니다.")
    @NotNull(message = "회원 타입은 필수 값입니다.")
    @Enumerated
    private Grade grade;

//    @NotBlank(message = "회원 타입은 필수 값입니다.")
    @NotNull(message = "회원 타입은 필수 값입니다.")
    @Enumerated
    private Type type;

    @Builder
    public MemberRequestDto(String loginId, String password, String name, Gender gender, String phoneNumber, String email, String address, String birth, Grade grade, Type type) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.birth = birth;
        this.grade = grade;
        this.type = type;
    }

    public MemberRequestDto(Long id, String loginId, String name, String password, Gender gender, String phoneNumber, String email, String address, String birth, Grade grade, Type type) {
        this.id = id;
        this.loginId = loginId;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.birth = birth;
        this.grade = grade;
        this.type = type;
    }

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .loginId(loginId)
                .name(name)
                .password(loginId)
                .gender(gender)
                .phoneNumber(phoneNumber)
                .email(email)
                .address(address)
                .birth(birth)
                .grade(grade)
                .type(type)
                .build();
    }
}
