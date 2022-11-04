package com.coupang.clone.Service;

import com.coupang.clone.controller.dto.MemberChangePasswordDto;
import com.coupang.clone.controller.dto.MemberRequestDto;
import com.coupang.clone.domain.Grade;
import com.coupang.clone.domain.Member;

import java.util.List;

public interface MemberService {
    Long save(MemberRequestDto memberRequestDto);
    //Long update(MemberRequestDto memberRequestDto);
    Member findMemberById(Long id);
    Member findMemberByLoginId(String loginId);
    List<Member> findMemberByName(String name);
    List<Member> findAllMember();
    String changePassword(MemberChangePasswordDto memberChangePasswordDto);
    String resetPassword(String loginId);
    String changeGrade(Long id, Grade grade);
    String deleteMember(Long id);
    String changePersonalInfo(Long id, String phoneNumber, String email, String address);
}
