package com.plass.traveling.domain.member.controller;

import com.plass.traveling.domain.member.dto.req.MemberLoginRequest;
import com.plass.traveling.domain.member.dto.req.MemberRegisterRequest;
import com.plass.traveling.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    @PostMapping("/login")
    public String login(@RequestBody MemberLoginRequest dto) {
        return service.login(dto);
    }

    @PostMapping("/register")
    public String register(@RequestBody MemberRegisterRequest dto) {
        service.register(dto);
        return "OK";
    }

}
