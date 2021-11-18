package com.likelion.spoonclass.common;

import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignUpDto;

public class DtoFactory {
    public static RequestAuthSignUpDto getMockSignUpDto(String email,String password, String name){
        return RequestAuthSignUpDto.builder()
                .email(email)
                .password(password)
                .name(name)
                .build();
    }
    public static RequestAuthSignUpDto getMockSignUpDto(){
        return RequestAuthSignUpDto.builder()
                .email("mock@email.com")
                .password("1111")
                .name("mock")
                .build();
    }

}
