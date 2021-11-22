package com.likelion.spoonclass.config.auth;

import com.likelion.spoonclass.common.EntityFactory;
import com.likelion.spoonclass.config.auth.security.MemberAdapter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;


public class MemberSecurityContextFactory implements WithSecurityContextFactory<MockMember> {
    @Override
    public SecurityContext createSecurityContext(MockMember mockMember) {
        MemberAdapter memberAdapter = new MemberAdapter(EntityFactory.getMockMember());
        Authentication authentication = new UsernamePasswordAuthenticationToken(memberAdapter,
                null,
                memberAdapter.getAuthorities());
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        return context;
    }
}
