package com.likelion.spoonclass.domain.attend;

import com.likelion.spoonclass.common.dto.BaseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseAttendDto extends BaseDto {
    private Long id;
    private String openKakao;

    @Builder
    public ResponseAttendDto(Long id, String openKakao){
        super();
        this.id = id;
        this.openKakao = openKakao;
    }
}
