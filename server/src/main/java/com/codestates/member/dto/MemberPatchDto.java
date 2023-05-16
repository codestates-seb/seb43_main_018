package com.codestates.member.dto;

import com.codestates.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class MemberPatchDto {
    @NotBlank(message = "ID는 공백이 아니어야 합니다.")
    private long memberId;
    @NotBlank(message = "UserName은 공백이 아니어야 합니다.")
    private String username;
    @NotBlank(message = "Password는 공백이 아니어야 합니다.")
    private String password;
    private Member.MemberStatus memberStatus;

    public void setMemberId(long memberId){
        this.memberId = memberId;
    }
}
