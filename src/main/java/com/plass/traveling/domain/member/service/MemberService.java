package com.plass.traveling.domain.member.service;

import com.plass.traveling.domain.member.dto.req.MemberLoginRequest;
import com.plass.traveling.domain.member.dto.req.MemberRegisterRequest;
import com.plass.traveling.domain.member.enums.MemberRoles;
import com.plass.traveling.domain.member.entity.MemberEntity;
import com.plass.traveling.domain.member.repository.MemberRepository;
import com.plass.traveling.global.auth.JwtProvider;
import com.plass.traveling.global.common.BaseResponse;
import com.plass.traveling.global.exception.CustomException;
import com.plass.traveling.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;
    private final JwtProvider provider;

    @Transactional(readOnly = true)
    public BaseResponse login (MemberLoginRequest dto) {
        MemberEntity entity = repository.findByPhone(dto.getPhone())
                .orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_EXIST));

        if (!entity.getPassword().equals(dto.getPassword())) {
            throw new CustomException(ErrorCode.MEMBER_NOT_MATCH);
        }

        return new BaseResponse(
                HttpStatus.OK,
                "토큰 발급 성공",
                provider.generate(entity)
        );
    }

    @Transactional
    public BaseResponse register (MemberRegisterRequest dto) {
        if (repository.existsByPhone(dto.getPhone())) {
            throw new CustomException(ErrorCode.MEMBER_ALREADY_EXIST);
        }

        repository.save(
                MemberEntity.builder()
                        .phone(dto.getPhone())
                        .password(dto.getPassword())
                        .role(MemberRoles.convert(dto.getRole()))
                        .build()
        );

        return new BaseResponse(
                HttpStatus.OK,
                "회원가입 성공"
        );
    }

}
