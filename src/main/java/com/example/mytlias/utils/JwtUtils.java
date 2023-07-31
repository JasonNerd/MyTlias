package com.example.mytlias.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private static final String secret = "rainbow";     // sign secret
    private static final long expire = 12*60*60*1000;   // 12 hours
    public static String jwtGenerate(Map<String, Object> payload) {
        return Jwts.builder()
                .setClaims(payload)
                .signWith(SignatureAlgorithm.HS256, secret)
                .setExpiration(new Date(System.currentTimeMillis()+expire))
                .compact();
    }
    public static Claims jwtParse(String jwt){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
