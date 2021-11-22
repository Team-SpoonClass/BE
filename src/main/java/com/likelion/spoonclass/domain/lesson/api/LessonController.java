package com.likelion.spoonclass.domain.lesson.api;

import com.likelion.spoonclass.config.auth.security.MemberAdapter;
import com.likelion.spoonclass.domain.lesson.dto.RequestLessonDto;
import com.likelion.spoonclass.domain.lesson.dto.ResponseLessonDto;
import com.likelion.spoonclass.domain.lesson.service.LessonService;
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
                                 @RequestBody RequestLessonDto requestDto) {
        ResponseLessonDto responseDto = ResponseLessonDto.builder()
                .id(lessonService.create(memberAdapter.getMember(), requestDto))
                .build();

        return ResponseEntity.ok(responseDto);
    }

    @Override
    @PostMapping("/modify")
    public ResponseEntity modify(@AuthenticationPrincipal MemberAdapter memberAdapter,
                                 @RequestParam(value = "id") Long id,
                                 @RequestBody RequestLessonDto requestDto) {
        ResponseLessonDto responseDto = ResponseLessonDto.builder()
                .id(lessonService.modify(memberAdapter.getMember(), id, requestDto))
                .build();

        return ResponseEntity.ok(responseDto);
    }
}
