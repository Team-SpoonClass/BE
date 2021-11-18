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

    @Builder
    public ResponseAuthSignInDto(String oriToken,String refreshToken){
        super();
        this.oriToken = oriToken;
        this.refreshToken = refreshToken;
        this.message = message;
    }

    public static ResponseAuthSignInDto of(String oriToken, String refreshToken){
        return ResponseAuthSignInDto.builder()
                .oriToken(oriToken)
                .refreshToken(refreshToken)
                .build();
    }
}
