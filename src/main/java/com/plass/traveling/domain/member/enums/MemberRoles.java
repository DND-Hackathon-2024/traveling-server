package com.plass.traveling.domain.member.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberRoles {

    ADMIN("ADMIN"),
    USER("USER");

    private final String name;

    public static MemberRoles convert(String name) {
        if (name.equals("ADMIN")) {
            return MemberRoles.ADMIN;
        }

        return MemberRoles.USER;
    }

}
