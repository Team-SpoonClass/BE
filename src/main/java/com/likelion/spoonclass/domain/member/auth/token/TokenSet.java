package com.likelion.spoonclass.domain.member.auth.token;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenSet {
    String oriToken;
    String refreshToken;
    String username;
    Long id;

    public static TokenSet of(String ori, String ref, String username, Long id){
        return TokenSet.builder()
                .oriToken(ori)
                .refreshToken(ref)
                .username(username)
                .id(id)
                .build();
    }
}
