package com.likelion.spoonclass.domain.member.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestAuthSignInDto {
    private String email;
    private String password;
}
