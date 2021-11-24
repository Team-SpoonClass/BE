package com.likelion.spoonclass.domain.lesson.dto;

import com.likelion.spoonclass.domain.lesson.Lesson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestLessonDto {
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
