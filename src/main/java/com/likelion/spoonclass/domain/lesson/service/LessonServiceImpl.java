package com.likelion.spoonclass.domain.lesson.service;

import com.likelion.spoonclass.domain.lesson.Lesson;
import com.likelion.spoonclass.domain.lesson.LessonRepository;
import com.likelion.spoonclass.domain.lesson.dto.RequestCreateLessonDto;
import com.likelion.spoonclass.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;

    @Override
    @Transactional
    public Lesson create(Member member, RequestCreateLessonDto requestDto) {
        Lesson lesson = requestDto.of();
        lesson.setCaptain(member);
        lessonRepository.save(lesson);

        return lesson;
    }

    @Override
    @Transactional
    public Lesson modify(Member member,Long id, RequestCreateLessonDto requestDto) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 클래스입니다."));
        lesson.modify(requestDto);

        return lesson;
    }
}
