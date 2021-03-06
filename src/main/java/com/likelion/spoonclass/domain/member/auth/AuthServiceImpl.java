package com.likelion.spoonclass.domain.member.auth;

import com.likelion.spoonclass.config.auth.jwt.JwtProvider;
import com.likelion.spoonclass.domain.member.Member;
import com.likelion.spoonclass.domain.member.auth.token.TokenSet;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignInDto;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignUpDto;
import com.likelion.spoonclass.domain.member.repository.MemberRepository;
import com.likelion.spoonclass.domain.univ.Univ;
import com.likelion.spoonclass.domain.univ.UnivRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("authService")
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final UnivRepository univRepository;

    @Override
    @Transactional
    public TokenSet login(RequestAuthSignInDto requestDto) {
        Member member = memberRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("일치하는 Email이 없습니다."));

        // 비밀번호가 일치하지 않으면
        if(!passwordEncoder.matches(requestDto.getPassword(), member.getPassword()))
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");

        return TokenSet.of(jwtProvider.create(member.getEmail(), member.getAuthority()),null, member.getName(), member.getId());
    }

    @Override
    @Transactional
    public Long join(RequestAuthSignUpDto requestDto) {
        // 중복되는 email이 있는지 확인
        if(isDuplicated(requestDto.getEmail()))
            throw new IllegalArgumentException("중복되는 이메일입니다.");

        // 비밀번호 암호화
        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));

        Univ univ = univRepository.findByName(requestDto.getUniv())
                .orElseThrow(() -> new IllegalArgumentException("없는 대학입니다."));

        Member member = requestDto.of();
        member.setUniv(univ);
        memberRepository.save(member);

        return member.getId();
    }

    private boolean isDuplicated(String email){
        Optional<Member> byEmail = memberRepository.findByEmail(email);
        return byEmail.isPresent();
    }

}
