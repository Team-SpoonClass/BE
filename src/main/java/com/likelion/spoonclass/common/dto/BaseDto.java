package com.likelion.spoonclass.common.dto;

import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseDto {
    private String message;
}
