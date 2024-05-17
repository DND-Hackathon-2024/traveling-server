package com.plass.traveling.global.auth;

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

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUserDetailsService service;
    private final JwtProvider provider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token == null) {
            doFilter(request, response, filterChain);
            return;
        }

        UserDetails detail = service.loadUserByUsername(provider.getIdx(token));

        Authentication auth = new UsernamePasswordAuthenticationToken(
                detail,
                null,
                detail.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(auth);

        doFilter(request, response, filterChain);
    }
}
