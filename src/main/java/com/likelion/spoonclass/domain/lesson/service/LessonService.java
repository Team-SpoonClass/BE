package com.likelion.spoonclass.domain.lesson.service;

import com.likelion.spoonclass.domain.lesson.Lesson;
import com.likelion.spoonclass.domain.lesson.dto.RequestCreateLessonDto;
import com.likelion.spoonclass.domain.member.Member;

public interface LessonService {
    Lesson create(Member member, RequestCreateLessonDto requestDto);
    Lesson modify(Member member,Long id, RequestCreateLessonDto requestDto);
}
