package com.likelion.spoonclass.domain.lesson.dto;

import com.likelion.spoonclass.common.dto.BaseDto;
import com.likelion.spoonclass.domain.lesson.LessonStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LessonDto extends BaseDto {
    private String description;
    private Long id;
    private String name;
    private String oneLineInfo;
    private String openKakao;
    private String club;
    private String representPath;
    private LessonStatus status;

    @Builder
    LessonDto(Long id, String name, String oneLineInfo, String openKakao,
              String description, String club, String representPath, LessonStatus status) {
        super();
        this.id = id;
        this.name = name;
        this.oneLineInfo = oneLineInfo;
        this.openKakao = openKakao;
        this.description = description;
        this.club = club;
        this.representPath = representPath;
        this.status = status;
    }

}
