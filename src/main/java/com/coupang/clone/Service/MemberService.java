package com.coupang.clone.Service;

import com.coupang.clone.controller.dto.MemberJoinRequestDto;
import com.coupang.clone.domain.Member;
import lombok.NoArgsConstructor;

import java.util.Optional;

public interface MemberService {
    Long save(MemberJoinRequestDto memberJoinRequestDto);
    Optional<Member> findMember(Long MemberID);

}
