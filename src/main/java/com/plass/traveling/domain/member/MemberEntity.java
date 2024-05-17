package com.plass.traveling.domain.member;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String phone; // 아이디

    private String password; // 비밀번호

    @Builder
    public MemberEntity (
            String phone,
            String password
    ) {
        this.phone = phone;
        this.password = password;
    }

}
