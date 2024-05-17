package com.plass.traveling.global.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plass.traveling.global.common.BaseResponse;
import com.plass.traveling.global.exception.ErrorCode;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.View;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUserDetailsService service;
    private final JwtProvider provider;
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token == null) {
            doFilter(request, response, filterChain);
            return;
        }

        if (provider.isExpired(token)) {
            setErrorResponse(response, ErrorCode.JWT_ALREADY_EXPIRED);
            return;
        }

        try {
            UserDetails detail = service.loadUserByUsername(provider.getIdx(token));

            Authentication auth = new UsernamePasswordAuthenticationToken(
                    detail,
                    null,
                    detail.getAuthorities()
            );

            SecurityContextHolder.getContext().setAuthentication(auth);
        } catch (NullPointerException e) {
            setErrorResponse(response, ErrorCode.NULL_POINTER_EXCEPTION);
            return;
        }

        doFilter(request, response, filterChain);
    }

    private void setErrorResponse(
            HttpServletResponse response,
            ErrorCode errorCode
    ) throws IOException {
        response.setStatus(errorCode.getHttpStatus().value());
        response.setContentType("application/json;charset=UTF-8");

        response.getWriter().write(
                objectMapper.writeValueAsString(
                        new BaseResponse (
                                errorCode.getHttpStatus(),
                                errorCode.getMessage()
                        )
            )
        );
    }

}
