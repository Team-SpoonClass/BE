package com.likelion.spoonclass.domain.photo;

import com.likelion.spoonclass.domain.lesson.Lesson;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@NoArgsConstructor
public class LessonPhoto extends Photo{

    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;
}
