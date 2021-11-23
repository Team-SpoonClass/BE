package com.likelion.spoonclass.domain.attend.api;

import com.likelion.spoonclass.common.dto.BaseDto;
import com.likelion.spoonclass.config.auth.security.MemberAdapter;
import com.likelion.spoonclass.domain.attend.ResponseAttendDto;
import com.likelion.spoonclass.domain.attend.service.AttendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AttendController implements AttendAPI{
    private final AttendService attendService;

    @Override
    public ResponseEntity recruit(@AuthenticationPrincipal MemberAdapter memberAdapter,
                                  @RequestParam(value = "id") Long lessonId) {
        Long id = attendService.recruit(memberAdapter.getMember(), lessonId);

        return ResponseEntity.ok(ResponseAttendDto.builder().id(id));
    }
}
