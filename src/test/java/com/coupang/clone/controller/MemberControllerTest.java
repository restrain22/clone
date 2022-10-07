package com.coupang.clone.controller;

import com.coupang.clone.Repository.MemberRepository;
import com.coupang.clone.controller.dto.MemberChangePasswordDto;
import com.coupang.clone.controller.dto.MemberJoinRequestDto;
import com.coupang.clone.domain.Member;
import org.junit.After;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.http.*;
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
    void 회원가입() {
        String name = "이름";
        String phoneNumber = "000-0000-0000";


        MemberJoinRequestDto dto = MemberJoinRequestDto.builder()
                .loginId("a1")
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

    @Test
    void 비밀번호변경(){

        MemberChangePasswordDto memberChangePasswordDto = new MemberChangePasswordDto();
        memberChangePasswordDto.setMemberId("a1");
        memberChangePasswordDto.setPassword("a2a3a4a5!");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<MemberChangePasswordDto> entity = new HttpEntity(memberChangePasswordDto,headers);

        String url = "http://localhost:"+port+"/member/changePassword";
        //when
        ResponseEntity<Object> responseEntity = restTemplate.exchange(url,HttpMethod.PUT,entity,Object.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void 비밀번호초기화(){

        String memberID = "a1";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity(memberID,headers);

        String url = "http://localhost:"+port+"/member/resetPassword?id="+memberID;
        //when
        ResponseEntity<Object> responseEntity = restTemplate.exchange(url,HttpMethod.PUT,entity,Object.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}