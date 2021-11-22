package com.likelion.spoonclass.domain.lesson;

import com.likelion.spoonclass.domain.BaseEntity;
import com.likelion.spoonclass.domain.attend.Attend;
import com.likelion.spoonclass.domain.club.Club;
import com.likelion.spoonclass.domain.photo.LessonPhoto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lesson extends BaseEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String openKakao;

    private String oneLineInfo;

    private String description;

    @OneToMany(mappedBy = "lesson")
    private List<Attend> attendList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Club club;

    @OneToMany(mappedBy = "lesson",cascade = CascadeType.ALL)
    private List<LessonPhoto> photoList = new ArrayList<>();
}
