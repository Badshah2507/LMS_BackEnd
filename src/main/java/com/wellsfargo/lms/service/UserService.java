package com.wellsfargo.lms.service;

import com.wellsfargo.lms.model.User;


public interface UserService {
    String saveUser(User user);
    User login(User userDto);
}
