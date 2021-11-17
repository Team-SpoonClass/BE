package com.likelion.spoonclass.domain.member.auth;

import com.likelion.spoonclass.domain.member.dto.request.RequestSignInMemberDto;
import com.likelion.spoonclass.domain.member.dto.request.RequestSignUpMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController implements AuthAPI {
    private final AuthService authService;

    @PostMapping("/signIn")
    @Override
    public ResponseEntity<?> signIn(@RequestBody RequestSignInMemberDto requestDto) {
        return authService.login(requestDto);
    }

    @PostMapping("/signUp")
    @Override
    public ResponseEntity<?> signUp(@RequestBody RequestSignUpMemberDto requestDto) {
        return authService.join(requestDto);
    }
}
