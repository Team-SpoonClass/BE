package com.likelion.spoonclass.domain.lesson.api;

import com.likelion.spoonclass.config.auth.security.MemberAdapter;
import com.likelion.spoonclass.domain.lesson.dto.RequestLessonDto;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface LessonAPI {
    ResponseEntity create(MemberAdapter memberAdapter, RequestLessonDto requestDto);

    ResponseEntity modify(MemberAdapter memberAdapter, Long id, RequestLessonDto requestDto);

    ResponseEntity remove(MemberAdapter memberAdapter, Long id);

    ResponseEntity getList(Pageable pageable);

    ResponseEntity close(MemberAdapter memberAdapter, Long id);

    ResponseEntity get(Long id);
}
