package com.wellsfargo.lms.controller;

import com.wellsfargo.lms.model.User;
import com.wellsfargo.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class LmsController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String welcomeMessage(){
        return "Welcome to LMS";
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User userDto) {
        return userService.saveUser(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User userDto) {
        User user = userService.login(userDto);
        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        } else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

    }
}
