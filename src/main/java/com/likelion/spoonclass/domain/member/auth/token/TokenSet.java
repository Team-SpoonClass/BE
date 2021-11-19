package com.likelion.spoonclass.domain.member.auth.token;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenSet {
    String oriToken;
    String refreshToken;

    public static TokenSet of(String ori, String ref){
        return TokenSet.builder()
                .oriToken(ori)
                .refreshToken(ref)
                .build();
    }
}
