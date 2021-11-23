package com.likelion.spoonclass.domain.lesson;

import com.likelion.spoonclass.domain.BaseEntity;
import com.likelion.spoonclass.domain.ValidateAuthority;
import com.likelion.spoonclass.domain.attend.Attend;
import com.likelion.spoonclass.domain.lesson.dto.LessonDetailDto;
import com.likelion.spoonclass.domain.lesson.dto.RequestLessonDto;
import com.likelion.spoonclass.domain.lesson.dto.ResponseLessonDto;
import com.likelion.spoonclass.domain.member.Member;
import com.likelion.spoonclass.domain.photo.LessonPhoto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Lesson extends BaseEntity implements ValidateAuthority {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String openKakao;

    private String oneLineInfo;

    private String description;

    private String club;

    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    private Member captain;

    @OneToMany(mappedBy = "lesson")
    private List<Attend> attendList = new ArrayList<>();

    @OneToMany(mappedBy = "lesson",cascade = CascadeType.ALL)
    private List<LessonPhoto> photoList = new ArrayList<>();

    public LessonDetailDto toResponseDto(){
        return LessonDetailDto.builder()
                .id(id)
                .name(name)
                .club(club)
                .oneLineInfo(oneLineInfo)
                .representPath("path")
                .build();
    }

    @Builder
    public Lesson (String name, String openKakao, String oneLineInfo, String description, String club){
        this.name = name;
        this.openKakao = openKakao;
        this.oneLineInfo = oneLineInfo;
        this.description = description;
        this.club = club;
    }

    public void modify(RequestLessonDto requestDto){
        this.name = requestDto.getName();
        this.description = requestDto.getDescription();
        this.openKakao = requestDto.getOpenKakao();
        this.oneLineInfo = requestDto.getOneLineInfo();
    }

    @Override
    public Member getMember() {
        return captain;
    }
}
