package com.likelion.spoonclass.domain.member.controller;

import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignInDto;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignUpDto;
import org.springframework.http.ResponseEntity;

public interface MemberAPI {

    ResponseEntity<?> signUp(RequestAuthSignUpDto requestAuthSignUpDto);

    ResponseEntity<?> signIn(RequestAuthSignInDto requestAuthSignInDto);


}
