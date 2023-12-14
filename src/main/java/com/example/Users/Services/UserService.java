package com.example.Users.Services;

import com.example.Users.dto.UserModel;
import com.example.Users.entity.UserEntity;
import com.example.Users.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends UserEntity {
     final UserRepository userRepository;


    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public String checkUser(UserModel userModel){
        UserEntity userEntity= userRepository.findByUsername(userModel.getUsername());
        if(userEntity!=null && userEntity.getPassword().equals(userModel.getPassword())){
            return "yes";
        }
        else {
            return "no";
        }
    }

public UserEntity addUser(UserModel userModel){
        UserEntity userEntity=new UserEntity();
        BeanUtils.copyProperties(userModel,userEntity);
        return userRepository.save(userEntity);
    }

}
