package com.coupang.clone.Service;

import com.coupang.clone.Repository.MemberRepository;
import com.coupang.clone.domain.Member;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public Long join(Member member) {
        validateDuplacateMember(member);

        memberRepository.save(member);
        return member.getMemberID();
    }

    private void validateDuplacateMember(Member member){
        memberRepository.findById(member.getMemberID())
                .ifPresent(member1 -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    @Override
    public  Optional<Member>  findMember(Long MemberID) {
        return memberRepository.findById(MemberID);
    }
}
