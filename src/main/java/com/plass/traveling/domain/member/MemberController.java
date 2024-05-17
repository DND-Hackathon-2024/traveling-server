package com.plass.traveling.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private MemberService service;

    @PostMapping("/login")
    public String login(@RequestBody MemberLoginRequest dto) {
        service.login(dto);
        return "OK";
    }

    @PostMapping("/register")
    public String register(@RequestBody MemberRegisterRequest dto) {
        service.register(dto);
        return "OK";
    }

}
