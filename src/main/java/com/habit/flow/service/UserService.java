package com.habit.flow.service;

import com.habit.flow.model.User;
import org.springframework.stereotype.Service;

/**
 * OLTS on 04.01.2017.
 */
@Service("userService")
public class UserService {

    public String validateUser(User user) {
        String userName = user.getName();
        String password = user.getPassword();
        if (userName != null && password != null && userName.equals("admin") && password.equals("1")) {
            return "true";
        } else {
            return "false";
        }
    }
}
