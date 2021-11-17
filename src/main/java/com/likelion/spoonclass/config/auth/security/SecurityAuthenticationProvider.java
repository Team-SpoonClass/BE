package com.likelion.spoonclass.config.auth.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class SecurityAuthenticationProvider implements AuthenticationProvider {
    private final UserDetailsService securityService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = (String)authentication.getCredentials();

        MemberAdapter memberAdapter = (MemberAdapter)securityService.loadUserByUsername(email);

        // 비밀번호 불일치
        if(!passwordEncoder.matches(password,memberAdapter.getPassword()))
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");

        return new UsernamePasswordAuthenticationToken(memberAdapter.getMember(),
                null,
                memberAdapter.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
