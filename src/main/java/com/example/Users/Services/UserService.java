package com.example.Users.Services;

import com.example.Users.dto.UserModel;
import com.example.Users.entity.UserEntity;
import com.example.Users.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends UserEntity {
     final UserRepository userRepository;


    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public String checkUser(UserModel userModel){
        Optional<UserEntity> userEntity= userRepository.findById(userModel.getUsername());
        if(userEntity.isPresent() && userEntity.get().getPassword().equals(userModel.getPassword())){
            return "yes";
        }
        else {
            return "no";
        }
    }

public UserEntity addUser(UserModel userModel){
        UserEntity userEntity=new UserEntity();
        userEntity.setUsername(userModel.getUsername());
        userEntity.setPassword(userModel.getUsername());

        return userRepository.save(userEntity);

}
//    public static UserData addUser(String username, String password){
//
//        UserData user=new UserData();
//        user.setUsername(username);
//        user.setPassword(password);
//
//        return userRepository.save(user);
//
//    }
}
