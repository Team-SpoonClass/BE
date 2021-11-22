package com.likelion.spoonclass.domain.lesson.dto;

import com.likelion.spoonclass.common.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseLessonDto extends BaseDto {
    private Long id;

    @Builder
    public ResponseLessonDto(Long id){
        super();
        this.id = id;
    }
}
