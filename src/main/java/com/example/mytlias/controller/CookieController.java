package com.example.mytlias.controller;

import com.example.mytlias.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * to demonstrate how the cookie works
 */
@RestController
public class CookieController {
    @GetMapping("/sc")
    public Result setCookie(HttpServletResponse response){
        // 在响应中添加 cookie 字段值
        response.addCookie(new Cookie("username", "rainbow"));
        return Result.success();
    }
    @GetMapping("/gc")
    public Result getCookie(HttpServletRequest request){
        // 浏览器发起请求会自动携带 cookie
        Cookie[] cookies = request.getCookies();
        for(Cookie c: cookies){
            if(c.getName().equals("username"))
                System.out.println("username: "+c.getValue());
        }
        return Result.success();
    }
}
