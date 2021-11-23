package com.likelion.spoonclass.domain.attend.service;

import com.likelion.spoonclass.domain.attend.Attend;
import com.likelion.spoonclass.domain.attend.AttendRepository;
import com.likelion.spoonclass.domain.lesson.Lesson;
import com.likelion.spoonclass.domain.lesson.LessonRepository;
import com.likelion.spoonclass.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttendServiceImpl implements AttendService{
    private final LessonRepository lessonRepository;
    private final AttendRepository attendRepository;

    @Override
    public Long recruit(Member member, Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new IllegalArgumentException("없는 클래스입니다."));
        lesson.validate(member);

        Attend attend = Attend.of(member, lesson);
        attendRepository.save(attend);

        return attend.getId();
    }

}
