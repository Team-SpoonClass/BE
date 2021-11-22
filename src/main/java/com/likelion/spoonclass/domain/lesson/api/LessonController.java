package com.likelion.spoonclass.domain.lesson.api;

import com.likelion.spoonclass.config.auth.security.MemberAdapter;
import com.likelion.spoonclass.domain.lesson.Lesson;
import com.likelion.spoonclass.domain.lesson.dto.RequestCreateLessonDto;
import com.likelion.spoonclass.domain.lesson.dto.ResponseLessonDto;
import com.likelion.spoonclass.domain.lesson.service.LessonService;
import com.likelion.spoonclass.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lesson")
public class LessonController implements LessonAPI {
    private final LessonService lessonService;

    @Override
    @PostMapping("/create")
    public ResponseEntity create(@AuthenticationPrincipal MemberAdapter memberAdapter,
                                 @RequestBody RequestCreateLessonDto requestDto) {
        Lesson lesson = lessonService.create(memberAdapter.getMember(), requestDto);
        ResponseLessonDto responseDto = ResponseLessonDto.builder().id(lesson.getId()).build();

        return ResponseEntity.ok(responseDto);
    }

    @Override
    @PostMapping("/modify")
    public ResponseEntity modify(@AuthenticationPrincipal MemberAdapter memberAdapter,
                                 @RequestParam(value = "id") Long id,
                                 @RequestBody RequestCreateLessonDto requestDto) {
        Lesson lesson = lessonService.modify(memberAdapter.getMember(), id, requestDto);
        ResponseLessonDto responseDto = ResponseLessonDto.builder().id(lesson.getId()).build();

        return ResponseEntity.ok(responseDto);
    }
}
