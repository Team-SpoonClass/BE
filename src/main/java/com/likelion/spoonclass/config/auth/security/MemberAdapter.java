package com.likelion.spoonclass.config.auth.security;

import com.likelion.spoonclass.domain.member.Authority;
import com.likelion.spoonclass.domain.member.Member;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;

public class MemberAdapter extends User {
    @Getter
    private Member member;

    public MemberAdapter(Member member){
        super(member.getEmail(),member.getPassword(), getAuthority(member.getAuthority()));
        this.member = member;
    }

    private static Collection<? extends GrantedAuthority> getAuthority(Authority authority){
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(authority.getRole()));
        return authorities;
    }

}
