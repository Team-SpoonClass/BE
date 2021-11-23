package com.likelion.spoonclass.domain.lesson.service;

import com.likelion.spoonclass.domain.lesson.dto.RequestLessonDto;
import com.likelion.spoonclass.domain.lesson.dto.ResponseLessonDto;
import com.likelion.spoonclass.domain.member.Member;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface LessonService {
    Long create(Member member, RequestLessonDto requestDto);
    Long modify(Member member,Long id, RequestLessonDto requestDto);
    Long remove(Member member, Long id);
    List<ResponseLessonDto> getList(Pageable pageable);
}
