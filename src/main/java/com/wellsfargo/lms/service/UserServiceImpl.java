package com.wellsfargo.lms.service;

import com.wellsfargo.lms.model.User;
import com.wellsfargo.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    private static String encryptString(String str) {
        StringBuilder sb = new StringBuilder();
        char[] c =str.toCharArray();
        for(char c1 : c){
            c1 = (char) (c1 + 2);
            sb.append(c1);
        }
        return sb.toString();
    }

    @Override
    public String saveUser(User user) {
        user.setPassword(encryptString(user.getPassword()));
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
    public User login(User userDto) {
        User user = findUserByName(userDto.getName());
        String pwdInDb = user.getPassword();
        if (pwdInDb.equals(encryptString(userDto.getPassword()))) {
            return user;
        } else {
            return null;
        }
    }
}
