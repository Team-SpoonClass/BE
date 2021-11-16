package com.likelion.spoonclass.domain.member.controller;

import com.likelion.spoonclass.domain.member.dto.request.RequestSignInMemberDto;
import com.likelion.spoonclass.domain.member.dto.request.RequestSignUpMemberDto;
import org.springframework.http.ResponseEntity;

public interface MemberAPI {

    ResponseEntity<?> signUp(RequestSignUpMemberDto requestSignUpMemberDto);

    ResponseEntity<?> signIn(RequestSignInMemberDto requestSignInMemberDto);


}
