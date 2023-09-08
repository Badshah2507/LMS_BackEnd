package com.wellsfargo.lms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LmsController {
    @GetMapping("/")
    public String welcomeMessage(){
        return "Welcome to LMS";
    }
}
