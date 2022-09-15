package com.coupang.clone.controller;

import com.coupang.clone.Repository.MemberRepository;
import com.coupang.clone.controller.dto.MemberJoinRequestDto;
import com.coupang.clone.domain.Member;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MemberControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void createForm() {
    }

    @Test
    void join() {
        String name = "이름";
        String phoneNumber = "000-0000-0000";


        MemberJoinRequestDto dto = MemberJoinRequestDto.builder()
                .memberID("a1")
                .password("a1")
                .birth("1994-06-22")
                .address("집")
                .email("메일")
                .gender("성별")
                .name(name)
                .phoneNumber(phoneNumber)
                .type("타입")
                .build();

        String url = "http://localhost:"+port+"/member/new";
        //when
        ResponseEntity<Object> responseEntity=restTemplate.postForEntity(url,dto,Object.class);


        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        //then
/*        assertThat(responseEntity.getStatusCode()).
                isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).
                isGreaterThan(0L);
        List<Member> all = memberRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getPhoneNumber()).isEqualTo(phoneNumber);*/

    }
}