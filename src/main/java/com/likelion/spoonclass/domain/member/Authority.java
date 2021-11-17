package com.likelion.spoonclass.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Authority {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String role;

}
