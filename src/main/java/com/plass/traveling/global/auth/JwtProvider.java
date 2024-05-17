package com.plass.traveling.global.auth;

import com.plass.traveling.domain.member.MemberEntity;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtProvider {

    private final SecretKey secretKey;

    public JwtProvider(
            @Value("${spring.jwt.secret}") String secretKey
    ) {
        this.secretKey = new SecretKeySpec(
                secretKey.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm()
        );
    }

    public String getIdx(String token) {
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public String generate (
            MemberEntity member
    ) {
        long now = new Date().getTime();

        return Jwts.builder()
                .claim("role", member.getRole())
                .subject(member.getIdx().toString())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(now + 60480000))
                .signWith(secretKey)
                .compact();
    }
}
