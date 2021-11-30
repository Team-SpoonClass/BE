package com.likelion.spoonclass.domain.lesson;

import com.likelion.spoonclass.domain.BaseEntity;
import com.likelion.spoonclass.domain.ValidateAuthority;
import com.likelion.spoonclass.domain.attend.Attend;
import com.likelion.spoonclass.domain.lesson.dto.LessonDetailDto;
import com.likelion.spoonclass.domain.lesson.dto.LessonDto;
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
    @Setter
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String openKakao;

    private String oneLineInfo;

    private String description;

    private String club;

    private String representPath;

    @Enumerated(EnumType.STRING)
    private LessonStatus status;

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
                .representPath(representPath)
                .status(status)
                .userId(captain.getId())
                .username(captain.getName())
                .build();
    }

    @Builder
    public Lesson (String name, String openKakao, String oneLineInfo, String description, String club){
        this.name = name;
        this.openKakao = openKakao;
        this.oneLineInfo = oneLineInfo;
        this.description = description;
        this.club = club;
        status = LessonStatus.OPEN;
        representPath = "path";
    }

    public void modify(RequestLessonDto requestDto){
        if(requestDto.getName() != null)
            this.name = requestDto.getName();
        if(requestDto.getDescription() != null)
            this.description = requestDto.getDescription();
        if(requestDto.getOpenKakao() != null)
            this.openKakao = requestDto.getOpenKakao();
        if(requestDto.getOneLineInfo() != null)
            this.oneLineInfo = requestDto.getOneLineInfo();
    }

    @Override
    public Member getMember() {
        return captain;
    }

    public void close() {
        this.status = LessonStatus.CLOSE;
    }

    public LessonDto getDto() {
        return LessonDto.builder()
                .description(description)
                .club(club)
                .id(id)
                .name(name)
                .oneLineInfo(oneLineInfo)
                .openKakao(openKakao)
                .representPath(representPath)
                .status(status)
                .userId(captain.getId())
                .username(captain.getName())
                .build();
    }
}
