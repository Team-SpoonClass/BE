package com.likelion.spoonclass.domain.member.repository;

import com.likelion.spoonclass.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
