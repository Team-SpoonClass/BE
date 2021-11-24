package com.likelion.spoonclass.domain.lesson.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LessonDetailDto {
    private Long id;
    private String name;
    private String club;
    private String oneLineInfo;
    private String representPath;

    @Builder
    public LessonDetailDto(Long id, String name, String club, String oneLineInfo, String representPath){
        super();
        this.id = id;
        this.name = name;
        this.club = club;
        this.oneLineInfo = oneLineInfo;
        this.representPath = representPath;
    }
}
