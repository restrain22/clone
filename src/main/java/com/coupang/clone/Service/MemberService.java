package com.coupang.clone.Service;

import com.coupang.clone.controller.dto.MemberChangePasswordDto;
import com.coupang.clone.controller.dto.MemberJoinRequestDto;
import com.coupang.clone.domain.Member;

import java.util.Optional;

public interface MemberService {
    Long save(MemberJoinRequestDto memberJoinRequestDto);
    Optional<Member> findMemberByLoginId(String loginId);
    Optional<Member> findMemberByName(String name);
    void changePassword(MemberChangePasswordDto memberChangePasswordDto);
    void resetPassword(String memberId);

}
