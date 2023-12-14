package com.example.Users.Controller;

import com.example.Users.dto.UserModel;
import com.example.Users.entity.UserEntity;
import com.example.Users.Services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends UserEntity {
    @Autowired
    UserService userService;

    @PostMapping("/valid")
    public String check(@RequestBody UserModel userModel){
        return userService.checkUser(userModel);
    }

    @PostMapping("/register")
    public UserEntity addUser(@RequestBody UserModel userModel){
        return userService.addUser(userModel);
    }
}

