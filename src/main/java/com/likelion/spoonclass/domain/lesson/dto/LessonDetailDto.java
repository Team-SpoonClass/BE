package com.likelion.spoonclass.domain.lesson.dto;

import com.likelion.spoonclass.domain.lesson.LessonStatus;
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
    private LessonStatus status;

    @Builder
    public LessonDetailDto(Long id, String name, String club, String oneLineInfo, String representPath, LessonStatus status){
        super();
        this.id = id;
        this.name = name;
        this.club = club;
        this.oneLineInfo = oneLineInfo;
        this.representPath = representPath;
        this.status = status;
    }
}
