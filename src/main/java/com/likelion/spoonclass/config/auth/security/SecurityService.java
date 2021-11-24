package com.likelion.spoonclass.config.auth.security;

import com.likelion.spoonclass.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("securityService")
@RequiredArgsConstructor
public class SecurityService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new MemberAdapter(memberRepository.findByEmail(email)
        .orElseThrow(()-> new UsernameNotFoundException("회원정보를 찾지 못했습니다.")));
    }
}
