package com.likelion.spoonclass.domain.member.dto.request;

import com.likelion.spoonclass.domain.member.Member;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestSignUpMemberDto {
    private String email;
    private String password;
    private String name;

    public Member of(){
        Member member = Member.builder()
                .email(this.email)
                .name(this.name)
                .password(this.password)
                .build();
        return member;
    }
}
