package com.coupang.clone.domain;

import com.coupang.clone.controller.dto.MemberResponseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor
@DynamicUpdate //변경 필드만 반영
@ToString(exclude = {"payment","favorites","comments"})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 20)
    @Length(min = 1,max = 20, message = "ID는 1~20자리만 가능합니다")
    @NotBlank(message = "로그인 ID는 필수 값입니다.")
    private String loginId;

    @Column(nullable = false)
    @NotBlank(message = "이름은 필수 값입니다.")
    private String name;

    @Column(nullable = false)
    @JsonIgnore
    @NotBlank(message = "비밀번호는 필수 값입니다.")
    private String password;

    @Column(nullable = false)
    @NotNull(message = "성별은 필수 값입니다.")
    private String gender;
    private String phoneNumber;

    @Column(nullable = false)
    @NotBlank(message = "이메일은 필수 값입니다.")
    @Email
    private String email;

    private String address;

    private String birth;

    @Column(nullable = false)
//    @NotBlank(message = "등급은 필수 값입니다.")
    @NotNull(message = "회원 타입은 필수 값입니다.")
    @Enumerated
    private Grade grade;

    @Column(nullable = false)
//    @NotBlank(message = "회원 타입은 필수 값입니다.")
    @NotNull(message = "회원 타입은 필수 값입니다.")
    @Enumerated
    private Type type;

    @OneToMany(mappedBy = "member")
    private List<Payment> payment = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Favorite> favorites = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Member(Long id, String loginId, String name, String password, Gender gender, String phoneNumber, String email, String address, String birth, Grade grade, Type type) {
        this.id = id;
        this.loginId = loginId;
        this.name = name;
        this.password = password;
        this.gender = gender.getCapital();
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.birth = birth;
        this.grade = grade;
        this.type = type;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public void changeGrade(Grade grade) {
        this.grade = grade;
    }

    public void changePersonalInfo(String phoneNumber, String email, String address) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
}
