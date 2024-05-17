package com.plass.traveling.global.auth;

import com.plass.traveling.domain.member.repository.MemberRepository;
import com.plass.traveling.global.exception.CustomException;
import com.plass.traveling.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final MemberRepository repository;

    @Override
    public UserDetails loadUserByUsername(String idx) throws UsernameNotFoundException {
        return new JwtUserDetails(
                repository.findById(Long.valueOf(idx)).orElseThrow(() -> new CustomException(
                        ErrorCode.MEMBER_NOT_EXIST
                ))
        );
    }

}
