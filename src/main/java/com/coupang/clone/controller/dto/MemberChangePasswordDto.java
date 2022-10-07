package com.coupang.clone.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberChangePasswordDto {
    private String memberId;
    private String password;
}
