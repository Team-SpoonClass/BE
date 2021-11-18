package com.likelion.spoonclass.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ResponseOnlyIdDto extends BaseDto {
    private Long id;

    @Builder
    public ResponseOnlyIdDto(Long id, String message){
        this.id = id;
        this.message = message;
    }

    public static ResponseOnlyIdDto of(Long id,String message){
        return ResponseOnlyIdDto.builder()
                .id(id)
                .message(message)
                .build();
    }
}
