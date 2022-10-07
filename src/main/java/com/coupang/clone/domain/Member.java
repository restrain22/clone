package com.coupang.clone.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate //변경 필드만 반영
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String loginId;
    private String name;
    private String password;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String birth;
    private String type;

    @OneToMany(mappedBy = "member")
    private List<Payment> payment = new ArrayList<>();

    @Builder
    public Member(String loginId, String name, String password, String gender, String phoneNumber, String email, String address, String birth, String type) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.birth = birth;
        this.type = type;
    }

    public void changePassword(String password){
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", loginId='" + loginId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", birth='" + birth + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
