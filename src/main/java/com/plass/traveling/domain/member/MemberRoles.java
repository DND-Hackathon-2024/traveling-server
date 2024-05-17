package com.plass.traveling.domain.member;

public enum MemberRoles {

    ADMIN("ADMIN"),
    USER("USER");

    MemberRoles (
            String name
    ) {}

    public static MemberRoles convert(String name) {
        if (name.equals("ADMIN")) {
            return MemberRoles.ADMIN;
        }

        return MemberRoles.USER;
    }

}
