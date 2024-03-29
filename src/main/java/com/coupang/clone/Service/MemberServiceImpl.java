package com.coupang.clone.Service;

import com.coupang.clone.Repository.MemberRepository;
import com.coupang.clone.controller.dto.MemberChangePasswordDto;
import com.coupang.clone.controller.dto.MemberRequestDto;
import com.coupang.clone.domain.Grade;
import com.coupang.clone.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Long save(MemberRequestDto dto) {
        Member member = dto.toEntity();
        validateDuplicateMember(member);
        Member save = memberRepository.save(member);
        return save.getId();
    }

//    @Override
//    public Long update(MemberRequestDto memberRequestDto) {
//        Long id = memberRepository.findByLoginId(memberRequestDto.getLoginId()).get().getId();
//        memberRequestDto.setId(id);
//        Member member = memberRequestDto.toEntity();
//        return memberRepository.save(member).getId();
//    }

    @Override
    public Member findMemberByLoginId(String loginId) {
        Member member = memberRepository.findByLoginId(loginId).orElseGet(() -> {
            throw new IllegalStateException("해당 사용자가 없습니다.");
        });
        return member;
    }

    @Override
    public Member findMemberById(Long id) {
        Member member = memberRepository.findById(id).orElseGet(() -> {
            throw new IllegalStateException("해당 사용자가 없습니다.");
        });
        return member;
    }

    @Override
    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }

    @Override
    public List<Member> findMemberByName(String name) {
        return memberRepository.findByName(name);
    }

    @Override
    public String deleteMember(Long id){
        //Cannot delete or update a parent row: a foreign key constraint fails (`clonedb`.`payment`, CONSTRAINT `FK4pswry4r5sx6j57cdeulh1hx8` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`))
        //다른 테이블 조인되어 있는 것 cascade 삭제 검토 "cart 자동 생성"
        memberRepository.findById(id).ifPresentOrElse(
                member -> memberRepository.deleteById(id)
                , () -> {
                    throw new IllegalStateException("해당 사용자가 없습니다.");
                }
        );
        return "Success";
    }

    @Override
    @Transactional
    public String changePassword(MemberChangePasswordDto memberChangePasswordDto) {
        memberRepository.findByLoginId(memberChangePasswordDto.getLoginId()).ifPresentOrElse(
                member -> {
                    String retVal = "";
                    if (!(retVal=checkPassword(memberChangePasswordDto.getLoginId(),memberChangePasswordDto.getPassword())).equals("")){
                        throw new IllegalArgumentException(retVal);
                    }
                    member.changePassword(memberChangePasswordDto.getPassword());
                    System.out.println("retVal = " + retVal + "member : " + member.toString());
                }
                , () -> {
                    throw new IllegalStateException("해당 사용자가 없습니다.");
                });
        return "Success";
    }

    @Override
    @Transactional
    public String resetPassword(String loginId) {
        memberRepository.findByLoginId(loginId).ifPresentOrElse(
                member -> {
                    String retVal = "";
                    if (!(retVal=checkPassword(loginId,member.getPassword())).equals("")){
                        throw new IllegalArgumentException(retVal);
                    }
                    member.changePassword(loginId);
                    System.out.println("retVal = " + retVal + "member : " + member.toString());
                }
                , () -> {
                    throw new IllegalStateException("해당 사용자가 없습니다.");
                });
        return "Success";
    }

    @Override
    @Transactional
    public String changeGrade(Long id,Grade grade){
        Member member = memberRepository.findById(id).orElseGet(
                () -> {
                    throw new IllegalStateException("해당 사용자가 없습니다.");
                }
        );
        member.changeGrade(grade);
        return "Success";
    }

    private void validateDuplicateMember(Member member){
        memberRepository.findByLoginId(member.getLoginId())
                .ifPresent(member1 -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    private String checkPassword(String id, String pwd){

        // 비밀번호 포맷 확인(영문, 특수문자, 숫자 포함 8자 이상)
        Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$");
        Matcher passMatcher1 = passPattern1.matcher(pwd);

        if(!passMatcher1.find()){
            return "비밀번호는 영문과 특수문자 숫자를 포함하며 8자 이상이어야 합니다.";
        }

        // 반복된 문자 확인
        Pattern passPattern2 = Pattern.compile("(\\w)\\1\\1\\1");
        Matcher passMatcher2 = passPattern2.matcher(pwd);

        if(passMatcher2.find()){
            return "비밀번호에 동일한 문자를 과도하게 연속해서 사용할 수 없습니다.";
        }

        // 아이디 포함 확인
        if(pwd.contains(id)){
            return "비밀번호에 ID를 포함할 수 없습니다.";
        }

        // 특수문자 확인
        Pattern passPattern3 = Pattern.compile("\\W");
        Pattern passPattern4 = Pattern.compile("[!@#$%^*+=-]");

        for(int i = 0; i < pwd.length(); i++){
            String s = String.valueOf(pwd.charAt(i));
            Matcher passMatcher3 = passPattern3.matcher(s);

            if(passMatcher3.find()){
                Matcher passMatcher4 = passPattern4.matcher(s);
                if(!passMatcher4.find()){
                    return "비밀번호에 특수문자는 !@#$^*+=-만 사용 가능합니다.";
                }
            }
        }

        //연속된 문자 확인
        int ascSeqCharCnt = 0; // 오름차순 연속 문자 카운트
        int descSeqCharCnt = 0; // 내림차순 연속 문자 카운트

        char char_0;
        char char_1;
        char char_2;

        int diff_0_1;
        int diff_1_2;

        for(int i = 0; i < pwd.length()-2; i++){
            char_0 = pwd.charAt(i);
            char_1 = pwd.charAt(i+1);
            char_2 = pwd.charAt(i+2);

            diff_0_1 = char_0 - char_1;
            diff_1_2 = char_1 - char_2;

            if(diff_0_1 == 1 && diff_1_2 == 1){
                ascSeqCharCnt += 1;
            }

            if(diff_0_1 == -1 && diff_1_2 == -1){
                descSeqCharCnt -= 1;
            }
        }

        if(ascSeqCharCnt > 1 || descSeqCharCnt > 1){
            return "비밀번호에 연속된 문자열을 사용할 수 없습니다.";
        }

        return "";
    }

    @Override
    @Transactional
    public String changePersonalInfo(Long id, String phoneNumber, String email, String address){
        Member member = memberRepository.findById(id).orElseGet(
                () -> {
                    throw new IllegalStateException("해당 사용자가 없습니다.");
                }
        );
        member.changePersonalInfo(phoneNumber,email,address);
        return "Success";
    }
}

