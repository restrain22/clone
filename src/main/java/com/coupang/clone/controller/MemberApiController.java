package com.coupang.clone.controller;

import com.coupang.clone.Service.MemberService;
import com.coupang.clone.controller.dto.MemberChangePasswordDto;
import com.coupang.clone.controller.dto.MemberRequestDto;
import com.coupang.clone.controller.dto.MemberResponseDto;
import com.coupang.clone.domain.Grade;
import com.coupang.clone.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping("/new")
    public Long join(@RequestBody @Valid MemberRequestDto memberRequestDto) {
        return memberService.save(memberRequestDto);
    }

    @PutMapping("/changePassword")
    public String changePassword(@RequestBody MemberChangePasswordDto memberChangePasswordDto){
        return memberService.changePassword(memberChangePasswordDto);
    }

    @PutMapping("/resetPassword")
    public String resetPassword(@RequestParam("id") String memberId){
        return memberService.resetPassword(memberId);
    }

//    public Long update(MemberRequestDto memberRequestDto) {
//        memberService.
//        return ;
//    }

    @GetMapping("/seq/{id}")
    public MemberResponseDto findMemberById(@PathVariable Long id) {
        return MemberResponseDto.of(memberService.findMemberById(id));
    }

    @GetMapping("/id/{loginId}")
    public MemberResponseDto findMemberByLoginId(@PathVariable String loginId){
        return MemberResponseDto.of(memberService.findMemberByLoginId(loginId));
    }

    @GetMapping("/name/{name}")
    public List<MemberResponseDto> findMemberByName(@PathVariable String name){
        return memberService.findMemberByName(name).stream().map(member -> new MemberResponseDto(member)).collect(Collectors.toList());
    }

    @GetMapping("/all")
    public List<MemberResponseDto> findAllMember(){
        return memberService.findAllMember().stream().map(member -> new MemberResponseDto(member)).collect(Collectors.toList());
    }

    @GetMapping("/grade")
    public String changeGrade(@RequestParam Long id,@RequestParam Grade grade){
        return memberService.changeGrade(id, grade);
    }

    @DeleteMapping("/delete")
    public String deleteMember(@RequestParam Long id){
        return memberService.deleteMember(id);
    }

    @PostMapping("/update")
    public String changePersonalInfo(@RequestBody MemberRequestDto memberRequestDto){
        //아직 개발 중
        Long id = memberRequestDto.getId();
        String phoneNumber = memberRequestDto.getPhoneNumber();
        String email = memberRequestDto.getEmail();
        String address = memberRequestDto.getAddress();

        return memberService.changePersonalInfo(id, phoneNumber, email, address);
    }
}
