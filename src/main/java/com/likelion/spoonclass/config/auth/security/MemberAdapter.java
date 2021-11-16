package com.likelion.spoonclass.config.auth.security;

import com.likelion.spoonclass.domain.member.Authority;
import com.likelion.spoonclass.domain.member.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;

public class MemberAdapter extends User {
    private Member member;

    public MemberAdapter(Member member){
        super(member.getEmail(),member.getPassword(),getAutority(member.getAuthority()));
        this.member = member;
    }

    private static Collection<? extends GrantedAuthority> getAutority(Authority authority){
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(authority.getRole()));
        return authorities;
    }

}
