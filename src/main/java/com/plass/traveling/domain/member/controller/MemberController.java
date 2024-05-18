package com.plass.traveling.domain.member.controller;

import com.plass.traveling.domain.member.dto.req.MemberLoginRequest;
import com.plass.traveling.domain.member.dto.req.MemberRegisterRequest;
import com.plass.traveling.domain.member.service.MemberService;
import com.plass.traveling.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    @PostMapping("/login")
    public BaseResponse login(@RequestBody MemberLoginRequest dto) {
        return service.login(dto);
    }

    @PostMapping("/register")
    public BaseResponse register(@RequestBody MemberRegisterRequest dto) {
        return service.register(dto);
    }

}
