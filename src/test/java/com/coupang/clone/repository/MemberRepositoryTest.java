package com.coupang.clone.repository;

import com.coupang.clone.Repository.MemberRepository;
import com.coupang.clone.domain.Gender;
import com.coupang.clone.domain.Member;
import com.coupang.clone.domain.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원등록() {
        Member member = Member.builder()
                .loginId("admin")
                .birth("0000-00-00")
                .address("집")
                .email("메일")
                .gender(Gender.Man)
                .name("관리자")
                .phoneNumber("000-000-0000")
                .type(Type.ADMIN)
                .build();

        memberRepository.save(member);
    }

    @Test
    void 회원ID검색() {
        Optional<Member> member = memberRepository.findById(1L);
        assertThat(member.get().getId()).isEqualTo(1L);
    }

    @Test
    void 회원로그인ID검색() {
        Optional<Member> member = memberRepository.findByLoginId("a1");
        assertThat(member.get().getId()).isEqualTo(1L);
    }

    @Test
    void 회원이름검색() {
        List<Member> member = memberRepository.findByName("이름");
        assertThat(member.get(0).getId()).isEqualTo(1L);
    }

    @Test
    void 회원전체검색() {
        List<Member> members = memberRepository.findAll();
        Member member = memberRepository.findById(1L).get();
        assertThat(members.get(0).getId()).isEqualTo(member.getId());
    }
}