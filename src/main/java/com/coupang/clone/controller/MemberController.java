package com.coupang.clone.controller;

import com.coupang.clone.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/form")
    public String createForm(){
        return "/member/createMemberForm";
    }



}
