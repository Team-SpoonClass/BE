package com.likelion.spoonclass.common;

import com.likelion.spoonclass.domain.lesson.dto.RequestLessonDto;
import com.likelion.spoonclass.domain.member.auth.token.TokenSet;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignInDto;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignUpDto;

public class DtoFactory {
    public static RequestAuthSignUpDto getMockSignUpDto(){
        return RequestAuthSignUpDto.builder()
                .email("mock@email.com")
                .password("1111")
                .name("mock")
                .univ("숭실대학교")
                .build();
    }

    public static RequestAuthSignInDto getMockSignInDto(){
        return RequestAuthSignInDto.builder()
                .email("mock@email.com")
                .password("1111")
                .build();
    }

    public static TokenSet getMockToken(){
        return TokenSet.of("originalTOken!@#!#!3f3f","refreshToken!@!@Q!@r112");
    }

    public static RequestLessonDto getMockLessonDto(){
        return RequestLessonDto.builder()
                .name("mock lesson")
                .club("mock club")
                .description("mock description")
                .oneLineInfo("mock info")
                .openKakao("mock kakao")
                .build();
    }
}
