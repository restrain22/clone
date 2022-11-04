package com.coupang.clone.controller;

import com.coupang.clone.Repository.MemberRepository;
import com.coupang.clone.controller.dto.MemberChangePasswordDto;
import com.coupang.clone.controller.dto.MemberRequestDto;
import com.coupang.clone.domain.Gender;
import com.coupang.clone.domain.Grade;
import com.coupang.clone.domain.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

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
        MemberRequestDto dto = MemberRequestDto.builder()
                .loginId("admin")
//                .birth("0000-00-00")
//                .address("집")
                .email("restrain22@naver.com")
                .gender(Gender.Man)
                .name("관리자")
//                .phoneNumber("000-0000-0000")
                .type(Type.PURCHASER)
                .grade(Grade.VIP)
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
        memberChangePasswordDto.setLoginId("37759");
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

        String memberID = "37759";

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