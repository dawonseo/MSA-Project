package com.sparta.msa_exam.auth.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class AuthService {

    @Value("${spring.jwt.access-expiration}")
    private Long accessExpiration;

    private final SecretKey secretKey;

    public AuthService(@Value("${service.jwt.secret-key") String secretKey) {
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
    }

    public String createAccessToken(String user_id){
        return Jwts.builder()
                .claim("user_id", user_id)
                .issuedAt(new Date(System.currentTimeMillis())) // 발행 날짜
                .expiration(new Date(System.currentTimeMillis() + accessExpiration)) // 만료 날짜
                .signWith(secretKey, SignatureAlgorithm.HS512) // 디코딩된 secretKey를 사용하여 알고리즘 서명
                .compact();
    }
}
