package com.example.Users.Repository;

import com.example.Users.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
    public UserEntity findByUsername(String userName);

}
