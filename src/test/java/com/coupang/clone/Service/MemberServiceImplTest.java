package com.coupang.clone.Service;

import com.coupang.clone.controller.dto.MemberChangePasswordDto;
import com.coupang.clone.controller.dto.MemberRequestDto;
import com.coupang.clone.domain.Gender;
import com.coupang.clone.domain.Type;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class MemberServiceImplTest {

    @Autowired
    MemberService memberService;



    @Test
    void save() {
        MemberRequestDto memberRequestDto = MemberRequestDto.builder()
                .loginId("loginId")
                .address("address")
                .birth("birth")
                .email("email")
                .gender(Gender.Man)
                .name("name")
                .password("password")
                .name("name")
                .type(Type.ADMIN)
                .build();

        memberService.save(memberRequestDto);
    }

//    @Test
//    void update() {
//        MemberRequestDto memberRequestDto = MemberRequestDto.builder()
//                .loginId("loginId")
//                .address("address")
//                .birth("birth")
//                .email("email")
//                .gender(Gender.Man)
//                .name("name")
//                .password("password")
//                .name("이름")
//                .type(Type.PURCHASER)
//                .build();
//
//
//        memberService.update(memberRequestDto);
//    }

    @Test
    void findMemberByLoginId(){
        memberService.findMemberByLoginId("a1");
    }

    @Test
    void findMemberByName() {
        memberService.findMemberByName("name");
    }

    @Test
    void changePassword() {
        MemberChangePasswordDto memberChangePasswordDto =
                MemberChangePasswordDto.builder()
                        .loginId("a1")
                        .password("1q2w3e4r!")
                        .build();
        memberService.changePassword(memberChangePasswordDto);
    }

    @Test
    void resetPassword() {
        memberService.resetPassword("a1");
    }
}