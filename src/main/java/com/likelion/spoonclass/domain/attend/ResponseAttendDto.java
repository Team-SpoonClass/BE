package com.likelion.spoonclass.domain.attend;

import com.likelion.spoonclass.common.dto.BaseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseAttendDto extends BaseDto {
    private Long id;

    @Builder
    public ResponseAttendDto(Long id){
        super();
        this.id = id;
    }
}
