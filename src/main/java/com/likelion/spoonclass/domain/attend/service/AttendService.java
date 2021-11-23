package com.likelion.spoonclass.domain.attend.service;

import com.likelion.spoonclass.domain.member.Member;

public interface AttendService {
    Long recruit(Member member, Long lessonId);
}
