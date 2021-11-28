package com.likelion.spoonclass.common;

import com.likelion.spoonclass.domain.attend.Attend;
import com.likelion.spoonclass.domain.lesson.Lesson;
import com.likelion.spoonclass.domain.lesson.dto.RequestLessonDto;
import com.likelion.spoonclass.domain.member.Member;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignUpDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


public class EntityFactory {
    public static Member getMockMember() {
        return Member.builder()
                .email("mock@email.com")
                .name("mockName")
                .password("1234")
                .build();
    }
    public static Member getMockMember(RequestAuthSignUpDto requestDto){
        return requestDto.of();
    }

    public static Lesson getMockLesson(RequestLessonDto requestDto) {
        Lesson lesson = requestDto.of();
        lesson.setId(1L);
        lesson.setCaptain(getMockMember(DtoFactory.getMockSignUpDto()));

        return lesson;
    }

    public static Attend getMockAttend(){
        Attend attend = Attend
                .of(EntityFactory.getMockMember(),
                        EntityFactory.getMockLesson(DtoFactory.getMockLessonDto()));
        attend.setId(1L);

        return attend;
    }
}
