package com.plass.traveling.domain.member.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRegisterRequest {

    private String phone;

    private String password;

    private String role; // ADMIN, USER

}
