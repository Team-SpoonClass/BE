package com.likelion.spoonclass.domain.lesson.dto;

import com.likelion.spoonclass.common.dto.BaseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseLessonIdDto extends BaseDto {
    private Long id;

    @Builder
    public ResponseLessonIdDto(Long id){
        super();
        this.id = id;
    }
}
