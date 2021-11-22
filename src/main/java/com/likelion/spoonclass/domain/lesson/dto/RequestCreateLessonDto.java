package com.likelion.spoonclass.domain.lesson.dto;

import com.likelion.spoonclass.domain.lesson.Lesson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RequestCreateLessonDto {
    private String name;
    private String oneLineInfo;
    private String club;
    private String description;
    private String openKakao;

    public Lesson of(){
        return Lesson.builder()
                .club(club)
                .description(description)
                .name(name)
                .oneLineInfo(oneLineInfo)
                .openKakao(openKakao)
                .build();
    }
}
