package com.coupang.clone.Service;

import com.coupang.clone.controller.dto.MemberJoinRequestDto;
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
        MemberJoinRequestDto memberJoinRequestDto = MemberJoinRequestDto.builder()
                .loginId("loginId")
                .address("address")
                .birth("birth")
                .email("email")
                .gender("gender")
                .name("name")
                .password("password")
                .name("name")
                .type("type")
                .build();

        memberService.save(memberJoinRequestDto);
    }

    @Test
    void findMemberByLoginId() {

    }

    @Test
    void findMemberByName() {
    }

    @Test
    void changePassword() {
    }

    @Test
    void resetPassword() {
    }
}