package com.likelion.spoonclass.domain.member.auth;

import com.likelion.spoonclass.common.dto.ResponseOnlyIdDto;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignInDto;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignUpDto;
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
    private final String MESSAGE_SUCCESS = "success";

    @PostMapping("/signIn")
    @Override
    public ResponseEntity<ResponseOnlyIdDto> signIn(@RequestBody RequestAuthSignInDto requestDto) {
        return ResponseEntity.ok().body(ResponseOnlyIdDto.of(authService.login(requestDto), MESSAGE_SUCCESS));
    }

    @PostMapping("/signUp")
    @Override
    public ResponseEntity<ResponseOnlyIdDto> signUp(@RequestBody RequestAuthSignUpDto requestDto) {
        return ResponseEntity.ok().body(ResponseOnlyIdDto.of(authService.join(requestDto), MESSAGE_SUCCESS));
    }
}
