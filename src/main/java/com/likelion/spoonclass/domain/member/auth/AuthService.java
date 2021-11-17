package com.likelion.spoonclass.domain.member.auth;

import com.likelion.spoonclass.domain.member.Member;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignInDto;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignUpDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    Long login(RequestAuthSignInDto requestDto);

    Long join(RequestAuthSignUpDto requestDto);
}
