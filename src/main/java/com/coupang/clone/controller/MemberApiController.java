package com.coupang.clone.controller;

import com.coupang.clone.Service.MemberService;
import com.coupang.clone.controller.dto.MemberJoinRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping("/member/new")
    public Long join(@RequestBody MemberJoinRequestDto memberJoinRequestDto) {
        return memberService.save(memberJoinRequestDto);
    }
}
