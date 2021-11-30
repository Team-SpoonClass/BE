package com.likelion.spoonclass.domain.member.dto.response;

import com.likelion.spoonclass.common.dto.BaseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseAuthSignInDto extends BaseDto {
    private String oriToken;
    private String refreshToken;
    private String username;

    @Builder
    public ResponseAuthSignInDto(String oriToken, String refreshToken, String username ){
        super();
        this.oriToken = oriToken;
        this.refreshToken = refreshToken;
        this.username = username;
    }

    public static ResponseAuthSignInDto of(String oriToken, String refreshToken, String username){
        return ResponseAuthSignInDto.builder()
                .oriToken(oriToken)
                .refreshToken(refreshToken)
                .username(username)
                .build();
    }
}
