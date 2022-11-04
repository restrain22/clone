package com.coupang.clone.Repository;

import com.coupang.clone.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByLoginId(String loginId);
    List<Member> findByName(String name);
    List<Member> findAll();
    void deleteById(Long id);
}
