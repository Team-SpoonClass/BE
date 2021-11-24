package com.likelion.spoonclass.domain.member.dto.request;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestAuthSignInDto {
    private String email;
    private String password;
}
