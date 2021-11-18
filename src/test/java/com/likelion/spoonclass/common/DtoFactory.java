package com.likelion.spoonclass.common;

import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignInDto;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignUpDto;

public class DtoFactory {
    public static RequestAuthSignUpDto getMockSignUpDto(){
        return RequestAuthSignUpDto.builder()
                .email("mock@email.com")
                .password("1111")
                .name("mock")
                .build();
    }

    public static RequestAuthSignInDto getMockSignInDto(){
        return RequestAuthSignInDto.builder()
                .email("mock@email.com")
                .password("1111")
                .build();
    }
}
