package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserinfoController {

    @GetMapping("/me")
    public String currentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = String.valueOf(authentication.getPrincipal());
        String authorities = String.valueOf(authentication.getAuthorities());
        return String.format("User: %s\nRoles: %s", user, authorities);
    }
}