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
    private final static String secret = "rainbow";
    private static final long expire = 2*60*60*1000;    // 有效时间持续 2h

    public static String generate(Map<String, Object> payload){
        return Jwts.builder()
                .setClaims(payload)
                .setExpiration(new Date(System.currentTimeMillis()+expire))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public static Claims parse(String jwt){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
