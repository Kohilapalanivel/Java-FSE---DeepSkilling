package com.example.jwt_authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt_authentication.jwt.JwtTokenProvider;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
public class HomeController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping("/token")
    public String generateToken(@RequestParam String username) {
        return jwtTokenProvider.createToken(username);
    }

    @GetMapping("/secure")
    public String secure() {
        return "This is a secure endpoint";
    }
}
