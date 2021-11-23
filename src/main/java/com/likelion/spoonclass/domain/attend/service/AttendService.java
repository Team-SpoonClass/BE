package com.likelion.spoonclass.domain.attend.service;

import com.likelion.spoonclass.domain.attend.Attend;
import com.likelion.spoonclass.domain.member.Member;

public interface AttendService {
    Attend recruit(Member member, Long lessonId);
}
