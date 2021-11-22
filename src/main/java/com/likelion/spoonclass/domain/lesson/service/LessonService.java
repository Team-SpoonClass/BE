package com.likelion.spoonclass.domain.lesson.service;

import com.likelion.spoonclass.domain.lesson.dto.RequestLessonDto;
import com.likelion.spoonclass.domain.member.Member;

public interface LessonService {
    Long create(Member member, RequestLessonDto requestDto);
    Long modify(Member member,Long id, RequestLessonDto requestDto);
    void remove(Member member, Long id);
}
