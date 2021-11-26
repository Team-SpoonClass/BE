package com.likelion.spoonclass.domain.member.auth;

import com.likelion.spoonclass.common.dto.ResponseOnlyIdDto;
import com.likelion.spoonclass.domain.member.auth.token.TokenSet;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignInDto;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignUpDto;
import com.likelion.spoonclass.domain.member.dto.response.ResponseAuthSignInDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController implements AuthAPI {
    private final AuthService authService;

    @PostMapping("/signIn")
    @Override
    public ResponseEntity<?> signIn(@RequestBody RequestAuthSignInDto requestDto) {
        TokenSet tokenSet = authService.login(requestDto);
        return ResponseEntity.ok().body(ResponseAuthSignInDto.of(tokenSet.getOriToken(),
                tokenSet.getRefreshToken()));
    }

    @PostMapping("/signUp")
    @Override
    public ResponseEntity<?> signUp(@RequestBody RequestAuthSignUpDto requestDto) {
        return ResponseEntity.ok().body(ResponseOnlyIdDto.of(authService.join(requestDto)));
    }
}
