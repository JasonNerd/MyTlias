package com.example.mytlias;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class MyTliasApplicationTests {
    @Test
    void jwtGenerate() {
        // 1. payload
        Map<String, Object> payload = new HashMap<>();
        payload.put("Mike", 2);
        payload.put("Silicon", "important");
        // 2. secret
        String secret = "rainbow";
        // 2. generate jwt
        String jwt = Jwts.builder()
                .setClaims(payload)         // 添加载荷
                .signWith(SignatureAlgorithm.HS256, secret)     // 签名算法以及密钥
                .setExpiration(new Date(System.currentTimeMillis()+3*60*1000))    // 有效时间, 例如这里是 3min
                .compact();
        System.out.println(jwt);
    }

    @Test
    void jwtParse(){
        String secret = "rainbow";
        // 刚刚生成的令牌, 注意有效期 3min
        String jwt = "eyJhbGciOiJIUzI1NiJ9." +
                "eyJNaWtlIjoyLCJTaWxpY29uIjoiaW1wb3J0YW50IiwiZXhwIjoxNjkwNjMzOTIxfQ." +
                "ka47GykiAGfRHUrQA6vmXsqdVqI5sBovJa9QInFYErA";
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(jwt)
                .getBody();
        System.out.println(claims);
        // {Mike=2, Silicon=important, exp=1690633921}
        System.out.println(new Date(1690633921));
    }

}
