package com.likelion.spoonclass.domain.member.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestSignInMemberDto {
    private String email;
    private String password;
}
