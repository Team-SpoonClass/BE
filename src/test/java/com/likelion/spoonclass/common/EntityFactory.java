package com.likelion.spoonclass.common;

import com.likelion.spoonclass.domain.member.Member;
import com.likelion.spoonclass.domain.member.dto.request.RequestAuthSignUpDto;

public class EntityFactory {
    public static Member getMockMember(RequestAuthSignUpDto requestDto){
        return requestDto.of();
    }

}
