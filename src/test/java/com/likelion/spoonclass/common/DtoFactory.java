package com.likelion.spoonclass.common;

import com.likelion.spoonclass.domain.lesson.Lesson;
import com.likelion.spoonclass.domain.lesson.LessonStatus;
import com.likelion.spoonclass.domain.lesson.dto.LessonDetailDto;
import com.likelion.spoonclass.domain.lesson.dto.LessonDto;
import com.likelion.spoonclass.domain.lesson.dto.RequestLessonDto;
import com.likelion.spoonclass.domain.lesson.dto.ResponseLessonDto;
import com.likelion.spoonclass.domain.member.auth.token.TokenSet;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignInDto;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignUpDto;

import java.util.List;

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

    public static LessonDetailDto getMockLessonDetailDto() {
        return LessonDetailDto.builder()
                .id(1L)
                .name("mock lesson")
                .club("mock club")
                .oneLineInfo("mock info")
                .representPath("mock path")
                .status(LessonStatus.OPEN)
                .build();
    }

    public static ResponseLessonDto getMockResponseLessonDto(List list) {
        return ResponseLessonDto.builder()
                .list(list)
                .build();
    }

    public static LessonDto getMockLessonDto(Lesson lesson) {
        return lesson.getDto();
    }
}
