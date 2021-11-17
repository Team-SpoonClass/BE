package com.likelion.spoonclass.domain.member.auth;

import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignInDto;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignUpDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> login(RequestAuthSignInDto requestDto);

    ResponseEntity<?> join(RequestAuthSignUpDto requestDto);
}
