package com.likelion.spoonclass.domain.lesson.dto;

import com.likelion.spoonclass.common.dto.BaseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseLessonDto extends BaseDto {
    private String name;
    private String club;
    private String oneLineInfo;
    private String representPath;

    @Builder
    public ResponseLessonDto(String name, String club, String oneLineInfo, String representPath){
        super();
        this.name = name;
        this.club = club;
        this.oneLineInfo = oneLineInfo;
        this.representPath = representPath;
    }
}
