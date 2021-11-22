package com.likelion.spoonclass.domain.lesson.api;

import com.likelion.spoonclass.config.auth.security.MemberAdapter;
import com.likelion.spoonclass.domain.lesson.Lesson;
import com.likelion.spoonclass.domain.lesson.dto.RequestCreateLessonDto;
import com.likelion.spoonclass.domain.member.Member;
import org.springframework.http.ResponseEntity;

public interface LessonAPI {
    ResponseEntity create(MemberAdapter memberAdapter, RequestCreateLessonDto requestDto);
    ResponseEntity modify(MemberAdapter memberAdapter, Long id, RequestCreateLessonDto requestDto);
}
