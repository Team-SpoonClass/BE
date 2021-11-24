package com.likelion.spoonclass.domain.member.dto.request;

import com.likelion.spoonclass.domain.member.Member;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestAuthSignUpDto {
    private String email;
    private String password;
    private String name;
    private String univ;

    public Member of(){
        Member member = Member.builder()
                .email(this.email)
                .name(this.name)
                .password(this.password)
                .build();
        return member;
    }
}
