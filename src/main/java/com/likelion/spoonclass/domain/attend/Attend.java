package com.likelion.spoonclass.domain.attend;

import com.likelion.spoonclass.domain.BaseEntity;
import com.likelion.spoonclass.domain.ValidateAuthority;
import com.likelion.spoonclass.domain.lesson.Lesson;
import com.likelion.spoonclass.domain.member.Member;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
public class Attend extends BaseEntity implements ValidateAuthority {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Enumerated(EnumType.STRING)
    private EnterType type = EnterType.RECRUIT;

    @Builder
    public Attend(Member member, Lesson lesson){
        this.member = member;
        this.lesson = lesson;
    }

    @Override
    public Member getMember() {
        return this.member;
    }

    public static Attend of(Member member, Lesson lesson){
        return Attend.builder()
                .member(member)
                .lesson(lesson)
                .build();
    }
}
