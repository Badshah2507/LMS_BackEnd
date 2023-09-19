package com.wellsfargo.lms.service;

import com.wellsfargo.lms.model.User;
import com.wellsfargo.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public String saveUser(User user) {
        try {
            userRepository.save(user);
            return "User Saved :-) !!!!";
        } catch (Exception e) {
            return "User NOT saved !!!!!!!!!!";
        }
    }

    public User findUserByName(String userName) {
        return userRepository.findByName(userName);
    }

    @Override
    public Map<String, String> login(User userDto) {
        User user = findUserByName(userDto.getName());
        if (user != null) {
            String pwdInDb = user.getPassword();
            if (pwdInDb.equals(userDto.getPassword())) {
                Map<String, String> responseBody = new HashMap<>();
                responseBody.put("name", user.getName());
                responseBody.put("role", user.getRole());
                responseBody.put("empId", user.getEmployeeId());
                return responseBody;
            } else {
                return null;
            }
        } else {
            return null;
        }

    }
}
