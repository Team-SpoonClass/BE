package com.likelion.spoonclass.domain.lesson.service;

import com.likelion.spoonclass.domain.lesson.dto.LessonDetailDto;
import com.likelion.spoonclass.domain.lesson.dto.LessonDto;
import com.likelion.spoonclass.domain.lesson.dto.RequestLessonDto;
import com.likelion.spoonclass.domain.member.Member;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LessonService {
    Long create(Member member, RequestLessonDto requestDto);
    Long modify(Member member,Long id, RequestLessonDto requestDto);
    Long remove(Member member, Long id);
    List<LessonDetailDto> getList(Pageable pageable);
    Long close(Member member, Long id);
    LessonDto get(Long id);
}
