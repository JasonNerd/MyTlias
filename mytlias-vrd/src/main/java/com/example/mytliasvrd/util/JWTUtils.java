package com.example.mytliasvrd.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.Map;

/**
 * 生成和校验令牌
 */
public class JWTUtils {
    @Value("${io.jsonwebtoken.secret}")
    private static String secret;
    private static final long expire = 12*60*60;    // 有效时间持续 12h

    public static String generate(Map<String, Object> payload){
        return Jwts.builder()
                .setClaims(payload)
                .setExpiration(new Date(System.currentTimeMillis()+expire))
                .signWith(SignatureAlgorithm.ES256, secret)
                .compact();
    }

    public static Claims parse(String jwt){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
