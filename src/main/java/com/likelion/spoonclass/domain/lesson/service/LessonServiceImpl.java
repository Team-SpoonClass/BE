package com.likelion.spoonclass.domain.lesson.service;

import com.likelion.spoonclass.domain.lesson.Lesson;
import com.likelion.spoonclass.domain.lesson.LessonRepository;
import com.likelion.spoonclass.domain.lesson.dto.RequestLessonDto;
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
    public Long create(Member member, RequestLessonDto requestDto) {
        Lesson lesson = requestDto.of();
        lesson.setCaptain(member);
        lessonRepository.save(lesson);

        return lesson.getId();
    }

    @Override
    @Transactional
    public Long modify(Member member,Long id, RequestLessonDto requestDto) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 클래스입니다."));
        lesson.validate(member);
        lesson.modify(requestDto);

        return lesson.getId();
    }

    @Override
    @Transactional
    public Long remove(Member member, Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 클래스입니다."));
        lesson.validate(member);
        lessonRepository.delete(lesson);

        return lesson.getId();
    }
}
