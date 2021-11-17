package com.likelion.spoonclass.domain.member.auth;

import com.likelion.spoonclass.domain.member.dto.request.RequestSignInMemberDto;
import com.likelion.spoonclass.domain.member.dto.request.RequestSignUpMemberDto;
import org.springframework.http.ResponseEntity;

public interface AuthAPI {
    ResponseEntity<?> signIn(RequestSignInMemberDto requestDto);

    ResponseEntity<?> signUp(RequestSignUpMemberDto requestDto);
}
