package com.wellsfargo.lms.service;

import com.wellsfargo.lms.model.User;

import java.util.Map;


public interface UserService {
    String saveUser(User user);
    Map<String, String> login(User userDto);
}
