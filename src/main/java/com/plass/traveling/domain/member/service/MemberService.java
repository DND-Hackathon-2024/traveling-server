package com.plass.traveling.domain.member.service;

import com.plass.traveling.domain.member.dto.req.MemberLoginRequest;
import com.plass.traveling.domain.member.dto.req.MemberRegisterRequest;
import com.plass.traveling.domain.member.enums.MemberRoles;
import com.plass.traveling.domain.member.entity.MemberEntity;
import com.plass.traveling.domain.member.repository.MemberRepository;
import com.plass.traveling.global.auth.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;
    private final JwtProvider provider;

    public String login (MemberLoginRequest dto) {
        MemberEntity entity = repository.findByPhone(dto.getPhone())
                .orElseThrow(IllegalAccessError::new);

        if (!entity.getPassword().equals(dto.getPassword())) {
            throw new IllegalAccessError();
        }

        return provider.generate(entity);
    }

    public void register (MemberRegisterRequest dto) {
        if (repository.existsByPhone(dto.getPhone())) {
            throw new IllegalAccessError();
        }

        repository.save(
                MemberEntity.builder()
                        .phone(dto.getPhone())
                        .password(dto.getPassword())
                        .role(MemberRoles.convert(dto.getRole()))
                        .build()
        );
    }

}
