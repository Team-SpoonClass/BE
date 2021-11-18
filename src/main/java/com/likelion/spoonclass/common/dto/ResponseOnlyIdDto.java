package com.likelion.spoonclass.common.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseOnlyIdDto extends BaseDto {
    private Long id;

    @Builder
    public ResponseOnlyIdDto(Long id, String message){
        super();
        this.id = id;
        this.message = message;
    }

    public static ResponseOnlyIdDto of(Long id){
        return ResponseOnlyIdDto.builder()
                .id(id)
                .build();
    }
}
