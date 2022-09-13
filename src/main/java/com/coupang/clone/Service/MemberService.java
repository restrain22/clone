package com.coupang.clone.Service;

import com.coupang.clone.domain.Member;
import lombok.NoArgsConstructor;

import java.util.Optional;

public interface MemberService {
    Long join(Member member);
    Optional<Member> findMember(Long MemberID);

}
