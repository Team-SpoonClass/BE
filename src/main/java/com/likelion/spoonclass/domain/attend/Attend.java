package com.likelion.spoonclass.domain.attend;

import com.likelion.spoonclass.domain.BaseEntity;
import com.likelion.spoonclass.domain.lesson.Lesson;
import com.likelion.spoonclass.domain.member.Member;

import javax.persistence.*;

@Entity
public class Attend extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Enumerated(EnumType.STRING)
    private EnterType type;
}
