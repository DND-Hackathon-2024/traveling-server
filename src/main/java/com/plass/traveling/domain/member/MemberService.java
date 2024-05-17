package com.plass.traveling.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private MemberRepository repository;

    public void login (MemberLoginRequest dto) {

    }

    public void register (MemberRegisterRequest dto) {
        repository.save(
                MemberEntity.builder()
                        .phone(dto.getPhone())
                        .password(dto.getPassword())
                        .build()
        );
    }

}
