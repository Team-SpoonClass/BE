package com.likelion.spoonclass.domain.attend.api;

import com.likelion.spoonclass.config.auth.security.MemberAdapter;
import org.springframework.http.ResponseEntity;

public interface AttendAPI {
    ResponseEntity recruit(MemberAdapter memberAdapter, Long lessonId);
}
