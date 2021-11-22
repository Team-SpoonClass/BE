package com.likelion.spoonclass.domain;

import com.likelion.spoonclass.domain.member.Member;
import org.springframework.security.access.AuthorizationServiceException;

public interface ValidateAuthority {
    default void validate(Member member){
        if( this.getMember().getId() != member.getId())
            throw new AuthorizationServiceException("접근 권한이 없는 회원입니다.");
    }
    Member getMember();
}
