package com.likelion.spoonclass.domain.lesson;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface LessonRepository extends JpaRepository<Lesson,Long> {
    Page<Lesson> findAll(Pageable pageable);
}
