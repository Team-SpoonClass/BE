package com.likelion.spoonclass.domain.club;

import com.likelion.spoonclass.domain.BaseEntity;
import com.likelion.spoonclass.domain.lesson.Lesson;
import com.likelion.spoonclass.domain.member.Member;
import com.likelion.spoonclass.domain.univ.Univ;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Club extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String openKakao;

    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    private Univ univ;

    @OneToMany(mappedBy = "club")
    private List<Lesson> lessonList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    private Member leader;

}
