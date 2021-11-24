package com.likelion.spoonclass.domain.lesson.dto;

import com.likelion.spoonclass.common.dto.BaseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ResponseLessonDto extends BaseDto {
    List<LessonDetailDto> lessonDetailDto;

    @Builder
    public ResponseLessonDto(List list){
        super();
        lessonDetailDto = list;
    }
}
