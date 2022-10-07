package com.coupang.clone.controller;

import com.coupang.clone.Service.MemberService;
import com.coupang.clone.controller.dto.MemberChangePasswordDto;
import com.coupang.clone.controller.dto.MemberJoinRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping("/member/new")
    public Long join(@RequestBody MemberJoinRequestDto memberJoinRequestDto) {
        return memberService.save(memberJoinRequestDto);
    }

    @PutMapping("/member/changePassword")
    public void changePassword(@RequestBody MemberChangePasswordDto memberChangePasswordDto){
        memberService.changePassword(memberChangePasswordDto);
    }

    @PutMapping("/member/resetPassword")
    public void resetPassword(@RequestParam("id") String memberId){
        memberService.resetPassword(memberId);
    }
}
