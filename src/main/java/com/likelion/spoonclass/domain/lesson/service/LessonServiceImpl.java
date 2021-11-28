package com.likelion.spoonclass.domain.lesson.service;

import com.likelion.spoonclass.domain.lesson.Lesson;
import com.likelion.spoonclass.domain.lesson.LessonRepository;
import com.likelion.spoonclass.domain.lesson.dto.LessonDetailDto;
import com.likelion.spoonclass.domain.lesson.dto.LessonDto;
import com.likelion.spoonclass.domain.lesson.dto.RequestLessonDto;
import com.likelion.spoonclass.domain.lesson.dto.ResponseLessonDto;
import com.likelion.spoonclass.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;

    @Override
    public Long create(Member member, RequestLessonDto requestDto) {
        Lesson lesson = requestDto.of();
        lesson.setCaptain(member);
        lessonRepository.save(lesson);

        return lesson.getId();
    }

    @Override
    public Long modify(Member member,Long id, RequestLessonDto requestDto) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 클래스입니다."));
        lesson.validate(member);
        lesson.modify(requestDto);

        return lesson.getId();
    }

    @Override
    public Long remove(Member member, Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 클래스입니다."));
        lesson.validate(member);
        lessonRepository.delete(lesson);

        return lesson.getId();
    }

    @Override
    public Long close(Member member, Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 클래스입니다."));
        lesson.validate(member);
        lesson.close();

        return lesson.getId();
    }

    @Override
    public List<LessonDetailDto> getList(Pageable pageable) {
        Page<Lesson> lessonPages = lessonRepository.findAll(pageable);
        return lessonPages.getContent()
                .stream()
                .map(Lesson::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public LessonDto get(Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 클래스입니다."));
        return lesson.getDto();
    }
}
