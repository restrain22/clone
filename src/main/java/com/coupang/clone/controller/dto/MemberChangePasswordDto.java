package com.coupang.clone.controller.dto;

import com.coupang.clone.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class MemberChangePasswordDto {
    @NotBlank(message = "로그인 ID는 필수 값입니다.")
    private String loginId;
    @NotBlank(message = "변경할 PW를 입력해야 합니다.")
    private String password;

    @Builder
    public MemberChangePasswordDto(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}
